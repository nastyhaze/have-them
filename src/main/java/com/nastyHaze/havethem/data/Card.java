package com.nastyHaze.havethem.data;

import com.nastyHaze.havethem.constant.Rank;
import com.nastyHaze.havethem.constant.Suit;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Card implements Comparable<Card>, Serializable {

    private Suit suit;
    private Rank rank;

    @Override
    public int compareTo(Card o) {
        int result = 0;

        if(rank.value() > o.getRank().value()) {
            result = 1;
        } else if(rank.value() < o.getRank().value()) {
            result = -1;
        }

        return result;
    }
}
