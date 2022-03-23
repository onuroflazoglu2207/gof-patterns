package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Truck extends Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identity;
    private String goods; // ice cream
    private Integer weight; // 15 grams
    private Integer total; // 140
    private String fromWhere; // california
    private String toWhere; // newYork

    public Truck() {
    }

    public Truck(TruckBuilder<?, ?> b) {
        super(b);
        this.identity = b.identity;
        this.goods = b.goods;
        this.weight = b.weight;
        this.total = b.total;
        this.fromWhere = b.fromWhere;
        this.toWhere = b.toWhere;
    }

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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
        } else if (!(o instanceof Truck)) {
            return false;
        } else {
            Truck other = (Truck) o;
            if (!super.equals(other)) return false;
            if (identity == null) {
                if (other.getIdentity() != null) return false;
            } else if (!identity.equals(other.getIdentity())) return false;
            if (goods == null) {
                if (other.getGoods() != null) return false;
            } else if (!goods.equals(other.getGoods())) return false;
            if (weight == null) {
                if (other.getWeight() != null) return false;
            } else if (!weight.equals(other.getWeight())) return false;
            if (total == null) {
                if (other.getTotal() != null) return false;
            } else if (!total.equals(other.getTotal())) return false;
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
        return super.toField() + ", identity=" + identity + ", goods=" + goods + ", weight=" +
                weight + ", total=" + total + ", fromWhere=" + fromWhere + ", toWhere=" + toWhere;
    }

    public String toString() {
        return "Truck(" + toField() + ")";
    }

    public static TruckBuilder<?, ?> builder() {
        return new TruckBuilderImpl();
    }

    private static final class TruckBuilderImpl extends TruckBuilder<Truck, TruckBuilderImpl> {
        private TruckBuilderImpl() {
        }

        protected TruckBuilderImpl self() {
            return this;
        }

        public Truck build() {
            return new Truck(this);
        }
    }

    public abstract static class TruckBuilder<C extends Truck, B extends TruckBuilder<C, B>> extends CarBuilder<C, B> {
        private Long identity;
        private String goods;
        private Integer weight;
        private Integer total;
        private String fromWhere;
        private String toWhere;

        TruckBuilder() {
        }

        public B identity(Long identity) {
            this.identity = identity;
            return self();
        }

        public B goods(String goods) {
            this.goods = goods;
            return self();
        }

        public B weight(Integer weight) {
            this.weight = weight;
            return self();
        }

        public B total(Integer total) {
            this.total = total;
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
