package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bus extends Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identity;
    private String busType;  //school service double-decker Neighbourhood hybrid police off-road
    private Integer seatCount; // seat count
    private String fromWhere; // rotterdam
    private String toWhere; // amsterdam

    public Bus() {
    }

    public Bus(BusBuilder<?, ?> b) {
        super(b);
        this.identity = b.identity;
        this.busType = b.busType;
        this.seatCount = b.seatCount;
        this.fromWhere = b.fromWhere;
        this.toWhere = b.toWhere;
    }

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
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

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Bus)) {
            return false;
        } else {
            Bus other = (Bus) o;
            if (!super.equals(other)) return false;
            if (identity == null) {
                if (other.getIdentity() != null) return false;
            } else if (!identity.equals(other.getIdentity())) return false;
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
            return true;
        }
    }

    public String toField() {
        return super.toField() + ", identity=" + identity + ", busType=" + busType +
                ", seatCount=" + seatCount + ", fromWhere=" + fromWhere + ", toWhere=" + toWhere;
    }

    public String toString() {
        return "Bus(" + toField() + ")";
    }

    public static BusBuilder<?, ?> builder() {
        return new BusBuilderImpl();
    }

    private static final class BusBuilderImpl extends BusBuilder<Bus, BusBuilderImpl> {
        private BusBuilderImpl() {
        }

        protected BusBuilderImpl self() {
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }

    public abstract static class BusBuilder<C extends Bus, B extends BusBuilder<C, B>> extends CarBuilder<C, B> {
        private Long identity;
        private String busType;
        private Integer seatCount;
        private String fromWhere;
        private String toWhere;

        BusBuilder() {
        }

        public B identity(Long identity) {
            this.identity = identity;
            return self();
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

        protected abstract B self();

        public abstract C build();
    }
}
