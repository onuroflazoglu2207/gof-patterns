package com.example.demo.dto;

public class AutomotiveDto extends CarDto {
    private String bodyType;
    private String fuelType;
    private String gearbox;
    private Boolean isFast; // gearbox == manual

    public AutomotiveDto() {
    }

    public AutomotiveDto(AutomotiveBuilder<?, ?> b) {
        super(b);
        this.bodyType = b.bodyType;
        this.fuelType = b.fuelType;
        this.gearbox = b.gearbox;
        this.isFast = b.isFast;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getGearbox() {
        return gearbox;
    }

    public Boolean getFast() {
        return isFast;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public void setFast(Boolean fast) {
        isFast = fast;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AutomotiveDto)) {
            return false;
        } else {
            AutomotiveDto other = (AutomotiveDto) o;
            if (!super.equals(other)) return false;
            if (bodyType == null) {
                if (other.getBodyType() != null) return false;
            } else if (!bodyType.equals(other.getBodyType())) return false;
            if (fuelType == null) {
                if (other.getFuelType() != null) return false;
            } else if (!fuelType.equals(other.getFuelType())) return false;
            if (gearbox == null) {
                if (other.getGearbox() != null) return false;
            } else if (!gearbox.equals(other.getGearbox())) return false;
            if (isFast == null) {
                if (other.getFast() != null) return false;
            } else if (!isFast.equals(other.getFast())) return false;
            return true;
        }
    }

    public String toField() {
        return super.toField() + ", bodyType=" + bodyType + ", fuelType=" + fuelType +
                ", gearbox=" + gearbox + ", isFast=" + isFast;
    }

    public String toString() {
        return "AutomotiveDto(" + toField() + ")";
    }

    public static AutomotiveBuilder<?, ?> builder() {
        return new AutomotiveBuilderImpl();
    }

    private static final class AutomotiveBuilderImpl extends AutomotiveBuilder<AutomotiveDto, AutomotiveBuilderImpl> {
        private AutomotiveBuilderImpl() {
        }

        protected AutomotiveBuilderImpl self() {
            return this;
        }

        public AutomotiveDto build() {
            return new AutomotiveDto(this);
        }
    }

    public abstract static class AutomotiveBuilder<C extends AutomotiveDto, B extends AutomotiveBuilder<C, B>> extends CarBuilder<C, B> {
        private String bodyType;
        private String fuelType;
        private String gearbox;
        private Boolean isFast;

        AutomotiveBuilder() {
        }

        public B bodyType(String bodyType) {
            this.bodyType = bodyType;
            return self();
        }

        public B fuelType(String fuelType) {
            this.fuelType = fuelType;
            return self();
        }

        public B gearbox(String gearbox) {
            this.gearbox = gearbox;
            return self();
        }

        public B isFast(Boolean isFast) {
            this.isFast = isFast;
            return self();
        }

        protected abstract B self();

        public abstract C build();
    }
}


