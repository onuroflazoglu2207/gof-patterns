package com.example.demo.dto;

public class BusDto extends CarDto {
    private String busType;
    private Integer seatCount;
    private String fromWhere;
    private String toWhere;
    private Boolean isBigBus; // seat count > 20

    public BusDto() {
    }

    public BusDto(BusBuilder<?, ?> b) {
        super(b);
        this.busType = b.busType;
        this.seatCount = b.seatCount;
        this.fromWhere = b.fromWhere;
        this.toWhere = b.toWhere;
        this.isBigBus = b.isBigBus;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getToWhere() {
        return toWhere;
    }

    public void setToWhere(String toWhere) {
        this.toWhere = toWhere;
    }

    public Boolean getBigBus() {
        return isBigBus;
    }

    public void setBigBus(Boolean bigBus) {
        isBigBus = bigBus;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BusDto)) {
            return false;
        } else {
            BusDto other = (BusDto) o;
            if (!super.equals(other)) return false;
            if (busType == null) {
                if (other.getBusType() != null) return false;
            } else if (!busType.equals(other.getBusType())) return false;
            if (seatCount == null) {
                if (other.getSeatCount() != null) return false;
            } else if (!seatCount.equals(other.getSeatCount())) return false;
            if (fromWhere == null) {
                if (other.getFromWhere() != null) return false;
            } else if (!fromWhere.equals(other.getFromWhere())) return false;
            if (toWhere == null) {
                if (other.getToWhere() != null) return false;
            } else if (!toWhere.equals(other.getToWhere())) return false;
            if (isBigBus == null) {
                if (other.getBigBus() != null) return false;
            } else if (!isBigBus.equals(other.getBigBus())) return false;
            return true;
        }
    }

    public String toField() {
        return super.toField() + ", busType=" + busType + ", seatCount=" + seatCount +
                ", fromWhere=" + fromWhere + ", toWhere=" + toWhere + ", isBigBus=" + isBigBus;
    }

    public String toString() {
        return "BusDto(" + toField() + ")";
    }

    public static BusBuilder<?, ?> builder() {
        return new BusBuilderImpl();
    }

    private static final class BusBuilderImpl extends BusBuilder<BusDto, BusBuilderImpl> {
        private BusBuilderImpl() {
        }

        protected BusBuilderImpl self() {
            return this;
        }

        public BusDto build() {
            return new BusDto(this);
        }
    }

    public abstract static class BusBuilder<C extends BusDto, B extends BusBuilder<C, B>> extends CarBuilder<C, B> {
        private String busType;
        private Integer seatCount;
        private String fromWhere;
        private String toWhere;
        private Boolean isBigBus;

        BusBuilder() {
        }

        public B busType(String busType) {
            this.busType = busType;
            return self();
        }

        public B seatCount(Integer seatCount) {
            this.seatCount = seatCount;
            return self();
        }

        public B fromWhere(String fromWhere) {
            this.fromWhere = fromWhere;
            return self();
        }

        public B toWhere(String toWhere) {
            this.toWhere = toWhere;
            return self();
        }

        public B isBigBus(Boolean isBigBus) {
            this.isBigBus = isBigBus;
            return self();
        }

        protected abstract B self();

        public abstract C build();
    }
}



