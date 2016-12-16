package com.fun.d2fun.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by zx on 2016/3/3.
 */

public
@Data
@ToString
@AllArgsConstructor
class MatchListInfo implements Serializable {

    private ResultEntity result;


    public
    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    static class ResultEntity {

        private List<LeaguesEntity> leagues;


        public
        @Data
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        static class LeaguesEntity {
            private String name;
            private int leagueid;
            private String description;
            private String tournament_url;
            private int itemdef;
        }
    }
}
