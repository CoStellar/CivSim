package com.civsim;

public class ApplicationInputParser {

        private MapSize mapsize;
        private Integer simRoundCount;
        private Integer civAmount;

        ApplicationInputParser(int argc, char argv){

        }

        public MapSize getMapSize() {

                return mapsize;
        }

        public Integer getSimRoundCount() {
                return simRoundCount;
        }

}
