package com.fun.d2fun.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by zx on 2016/3/3.
 */
@Data
@ToString
@AllArgsConstructor
public class MatchListInfo {

    private ResultEntity result;

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultEntity {

        private List<LeaguesEntity> leagues;

        @Data
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class LeaguesEntity {
            private String name;
            private int leagueid;
            private String description;
            private String tournament_url;
            private int itemdef;
        }
    }
}
