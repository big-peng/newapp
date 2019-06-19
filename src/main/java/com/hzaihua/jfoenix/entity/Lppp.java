package com.hzaihua.jfoenix.entity;

import java.util.Date;

public class Lppp {
        private int PNO;
        private int PNUM;
        private Date DateTime;
        private String CollctionCyc;
        private String DataType;
        private String Data;

        @Override
        public String toString() {
            return "lp{" +
                    "PNO=" + PNO +
                    ", PNUM=" + PNUM +
                    ", DateTime=" + DateTime +
                    ", CollctionCyc='" + CollctionCyc + '\'' +
                    ", DataType='" + DataType + '\'' +
                    ", Data='" + Data + '\'' +
                    '}';
        }

        public Lppp(int PNO, int PNUM, Date dateTime, String collctionCyc, String dataType, String data) {
            this.PNO = PNO;
            this.PNUM = PNUM;
            DateTime = dateTime;
            CollctionCyc = collctionCyc;
            DataType = dataType;
            Data = data;
        }

        public int getPNO() {
            return PNO;
        }

        public void setPNO(int PNO) {
            this.PNO = PNO;
        }

        public int getPNUM() {
            return PNUM;
        }

        public void setPNUM(int PNUM) {
            this.PNUM = PNUM;
        }

        public Date getDateTime() {
            return DateTime;
        }

        public void setDateTime(Date dateTime) {
            DateTime = dateTime;
        }

        public String getCollctionCyc() {
            return CollctionCyc;
        }

        public void setCollctionCyc(String collctionCyc) {
            CollctionCyc = collctionCyc;
        }

        public String getDataType() {
            return DataType;
        }

        public void setDataType(String dataType) {
            DataType = dataType;
        }

        public String getData() {
            return Data;
        }

        public void setData(String data) {
            Data = data;
        }

        public Lppp() {
        }
}
