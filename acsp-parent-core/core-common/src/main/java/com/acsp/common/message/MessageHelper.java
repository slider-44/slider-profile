package com.acsp.common.message;

import static com.acsp.common.message.Message.MESSAGE_ATTRIBUTE;
import static com.acsp.common.message.Message.Type.DANGER;
import static com.acsp.common.message.Message.Type.INFO;
import static com.acsp.common.message.Message.Type.SUCCESS;
import static com.acsp.common.message.Message.Type.WARNING;

import com.acsp.common.message.Message.Type;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public final class MessageHelper {

  public MessageHelper() {}

  public void addSuccessAttribute(Model model, String message, Object... args) {

    addAttribute(model, message, SUCCESS, args);
  }

  public void addErrorAttribute(Model model, String message, Object... args) {

    addAttribute(model, message, DANGER, args);
  }

  public void addInfoAttribute(Model model, String message, Object... args) {

    addAttribute(model, message, INFO, args);
  }

  public void addWarningAttribute(Model model, String message, Object... args) {

    addAttribute(model, message, WARNING, args);
  }

  private void addAttribute(Model model, String message, Type type, Object... args) {

    if ( model instanceof RedirectAttributes ) {

      ((RedirectAttributes) model).addFlashAttribute(MESSAGE_ATTRIBUTE,
                                                     new Message(message, type, args));

    } else {

      model.addAttribute(MESSAGE_ATTRIBUTE, new Message(message, type, args));

    }

  }

}
