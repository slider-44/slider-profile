package com.acsp.core.orm;

/**
 * Created by fsoli_000 on 01/02/2016.
 */
public class Pair<F, S> {

  private F first; // first member of pair

  private S second; // second member of pair

  public Pair(F first, S second) {
    this.first = first;
    this.second = second;
  }

  public F getFirst() {

    return first;
  }

  public S getSecond() {

    return second;
  }

}
