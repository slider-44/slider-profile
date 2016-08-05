package com.acsp.gateway.repository;

import static com.acsp.core.rs.db.tables.MAccountPermission.M_ACCOUNT_PERMISSION;
import static com.acsp.core.rs.db.tables.MMenuHead.M_MENU_HEAD;
import static com.acsp.core.rs.db.tables.MMenuItem.M_MENU_ITEM;

import com.acsp.core.orm.Pair;
import com.acsp.gateway.dto.Menu;
import com.acsp.gateway.dto.MenuItem;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

  @Autowired
  DSLContext jooq;

  @Override
  public List<Menu> retrieveUserMenuPermission(String userCd) {

    Result<Record> menus = jooq
                               .select(M_ACCOUNT_PERMISSION.USERCD)
                               .select(M_ACCOUNT_PERMISSION.READ)
                               .select(M_ACCOUNT_PERMISSION.WRITE)
                               .select(M_MENU_HEAD.NAME.as("MENU_HEAD_NAME"))
                               .select(M_MENU_HEAD.ICON.as("MENU_HEAD_ICON"))
                               .select(M_MENU_HEAD.PROJECT)
                               .select(M_MENU_HEAD.DISPLAYORDER.as("MENU_HEAD_DISPLAYORDER"))
                               .select(M_MENU_ITEM.NAME.as("MENU_ITEM_NAME"))
                               .select(M_MENU_ITEM.MODULE)
                               .select(M_MENU_ITEM.ICON.as("MENU_ITEM_ICON"))
                               .select(M_MENU_ITEM.DISPLAYORDER.as("MENU_ITEM_DISPLAYORDER"))

                               .from(M_ACCOUNT_PERMISSION)

                               .leftJoin(M_MENU_ITEM).on(M_ACCOUNT_PERMISSION.MENUITEMID.eq(M_MENU_ITEM.ID))
                               .leftJoin(M_MENU_HEAD).on(M_MENU_ITEM.MENUHEADID.eq(M_MENU_HEAD.ID))

                               .where(M_ACCOUNT_PERMISSION.USERCD.eq(userCd))

                               .orderBy(M_MENU_HEAD.DISPLAYORDER.asc(),
                                        M_MENU_ITEM.DISPLAYORDER.asc())

                               .fetch();

    List<Menu> menuItems = menus.stream()

                                .map(r -> {
                                  Menu menu = new Menu();
                                  menu.setName(r.getValue(M_MENU_HEAD.NAME.as("MENU_HEAD_NAME")));
                                  menu.setIcon(r.getValue(M_MENU_HEAD.ICON.as("MENU_HEAD_ICON")));
                                  menu.setProject(r.getValue(M_MENU_HEAD.PROJECT));
                                  menu.setDisplayOrder(r.getValue(M_MENU_HEAD.DISPLAYORDER.as("MENU_HEAD_DISPLAYORDER")));

                                  MenuItem menuItem = new MenuItem();
                                  menuItem.setName(r.getValue(M_MENU_ITEM.NAME.as("MENU_ITEM_NAME")));
                                  menuItem.setIcon(r.getValue(M_MENU_ITEM.ICON.as("MENU_ITEM_ICON")));
                                  menuItem.setModule(r.getValue(M_MENU_ITEM.MODULE));
                                  menuItem.setRead(BigDecimal.ONE.equals(r.getValue(M_ACCOUNT_PERMISSION.READ)));
                                  menuItem.setWrite(BigDecimal.ONE.equals(r.getValue(M_ACCOUNT_PERMISSION.WRITE)));

                                  return new Pair<>(menu, menuItem);
                                })

                                .collect(Collectors.groupingBy(Pair::getFirst,
                                                               Collectors.mapping(Pair::getSecond,
                                                                                  Collectors.toList())))

                                .entrySet().stream()

                                .map(entry -> {
                                  entry.getKey().setMenuItems(entry.getValue());
                                  return entry.getKey();
                                })

                                .collect(Collectors.toList());


    menuItems.sort((Menu menu1, Menu menu2) -> {

      return menu1.getDisplayOrder().compareTo(menu2.getDisplayOrder());
      
    });

    return menuItems;
  }

}
