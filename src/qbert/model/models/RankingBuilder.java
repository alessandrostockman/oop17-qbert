package qbert.model.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
/**
 * The implementation of {@link Model} for build ranking data.
 */
public class RankingBuilder {
 
  private Integer score;
  private String name;
  private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  private Date date;
   /**
   * Construct.
   * @param builder for initzialize attribute of object
   */
  public RankingBuilder(final Builder builder) {
    score = builder.scoreB;
    name = builder.nameB;
    date = builder.dateB;
  }
  @Override
  public final String toString() {
    return this.name + '#' + this.dateFormat.format(this.date) + '?' + this.score;
  }
  /**
   * Get only name of object.
   * @return the name object
   */
  public String getName() {
      return this.name;
  }
  /**
   * The implementation of builder pattern.
   */
  public static class Builder {
      private static final Integer NCHARACTER = 3;
      private Integer scoreB;
      private String nameB = "";
      private Date dateB = new Date();
      private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      /**
       * Constructor.
       */
      public Builder() {
      }
      /**
       * Add score to the object.
       * @param i is score
       * @return the entire object
       */
      public Builder addScore(final Integer i) {
          scoreB = i;
          return this;
      }
      /**
       * Add char to name of player.
       * @param i is index in alphabetic
       * @return the entire object
       */
      public Builder addChar(final Integer i) {
          if (nameB.length() <= NCHARACTER) {
              nameB += alphabet.charAt(i);
          }
          return this;
      }
      /**
       * Reset all data.
       * @return the entire object
       */
      public Builder reset() {
          nameB = " ";
          dateB = new Date();
          return this;
      }
      /**
       * Build the object.
       * @return the entire object
       */
      public RankingBuilder build() {
          return new RankingBuilder(this);
      }
    }

}