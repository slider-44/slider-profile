package com.acsp.common.message;

/**
 * A message to be displayed in web context. Depending on the type, different style will be applied.
 */
public class Message implements java.io.Serializable {

  private static final long serialVersionUID = 1904725220542247495L;

  /**
   * Name of the flash attribute.
   */
  public static final String MESSAGE_ATTRIBUTE = "message";

  /**
   * The type of the message to be displayed. 
   * The type is used to show message in a different style.
   */
  public static enum Type {
                           DANGER, 
                           WARNING, 
                           INFO, 
                           SUCCESS;
  }

  private final String message;

  private final Type type;

  private final Object[] args;

  /**
   * Construct an instance of Message given the message and type of message.
   * @param message Message that will be displayed/sent.
   * @param type Type of message that will be used by UI to format this message.
   */
  public Message(String message, Type type) {
    this.message = message;
    this.type = type;
    this.args = null;
  }

  /**
   * Construct an instance of Message given the message (with its arguments) and type of message.
   * @param message Message that will be displayed/sent.
   * @param type Type of message that will be used by UI to format this message.
   * @param args Sequence of argument values that will be used to resolve the message.
   */
  public Message(String message, Type type, Object... args) {
    this.message = message;
    this.type = type;
    this.args = args;
  }

  public String getMessage() {

    return message;
  }

  public Type getType() {

    return type;
  }

  public Object[] getArgs() {

    return args;
  }
}
