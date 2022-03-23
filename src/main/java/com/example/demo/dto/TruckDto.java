package com.example.demo.dto;

public class TruckDto extends CarDto {
    private String goods;
    private Integer weight;
    private Integer total;
    private String fromWhere;
    private String toWhere;
    private Long sumWeight; // weight * total

    public TruckDto() {
    }

    public TruckDto(TruckBuilder<?, ?> b) {
        super(b);
        this.goods = b.goods;
        this.weight = b.weight;
        this.total = b.total;
        this.fromWhere = b.fromWhere;
        this.toWhere = b.toWhere;
        this.sumWeight = b.sumWeight;
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

    public Long getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(Long sumWeight) {
        this.sumWeight = sumWeight;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TruckDto)) {
            return false;
        } else {
            TruckDto other = (TruckDto) o;
            if (!super.equals(other)) return false;
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
            if (sumWeight == null) {
                if (other.getSumWeight() != null) return false;
            } else if (!sumWeight.equals(other.getSumWeight())) return false;
            return true;
        }
    }


    public String toField() {
        return super.toField() + ", goods=" + goods + ", weight=" + weight + ", total=" + total +
                ", fromWhere=" + fromWhere + ", toWhere=" + toWhere + ", sumWeight=" + sumWeight;
    }

    public String toString() {
        return "TruckDto(" + toField() + ")";
    }

    public static TruckBuilder<?, ?> builder() {
        return new TruckBuilderImpl();
    }

    private static final class TruckBuilderImpl extends TruckBuilder<TruckDto, TruckBuilderImpl> {
        private TruckBuilderImpl() {
        }

        protected TruckBuilderImpl self() {
            return this;
        }

        public TruckDto build() {
            return new TruckDto(this);
        }
    }

    public abstract static class TruckBuilder<C extends TruckDto, B extends TruckBuilder<C, B>> extends CarBuilder<C, B> {
        private String goods;
        private Integer weight;
        private Integer total;
        private String fromWhere;
        private String toWhere;
        private Long sumWeight;

        TruckBuilder() {
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

        public B sumWeight(Long sumWeight) {
            this.sumWeight = sumWeight;
            return self();
        }

        protected abstract B self();

        public abstract C build();
    }
}

