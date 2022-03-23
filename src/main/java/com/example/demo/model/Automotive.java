package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Automotive extends Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identity;
    private String bodyType; //suv sedan coupe minivan
    private String fuelType; //gasoline diesel electric
    private String gearbox; //automatic manual semiautomatic

    public Automotive() {
    }

    public Automotive(AutomotiveBuilder<?, ?> b) {
        super(b);
        this.identity = b.identity;
        this.bodyType = b.bodyType;
        this.fuelType = b.fuelType;
        this.gearbox = b.gearbox;
    }

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Automotive)) {
            return false;
        } else {
            Automotive other = (Automotive) o;
            if (!super.equals(other)) return false;
            if (identity == null) {
                if (other.getIdentity() != null) return false;
            } else if (!identity.equals(other.getIdentity())) return false;
            if (bodyType == null) {
                if (other.getBodyType() != null) return false;
            } else if (!bodyType.equals(other.getBodyType())) return false;
            if (fuelType == null) {
                if (other.getFuelType() != null) return false;
            } else if (!fuelType.equals(other.getFuelType())) return false;
            if (gearbox == null) {
                if (other.getGearbox() != null) return false;
            } else if (!gearbox.equals(other.getGearbox())) return false;
            return true;
        }
    }

    public String toField() {
        return super.toField() + ", identity=" + identity + ", bodyType=" + bodyType +
                ", fuelType=" + fuelType + ", gearbox=" + gearbox;
    }

    public String toString() {
        return "Automotive(" + toField() + ")";
    }

    public static AutomotiveBuilder<?, ?> builder() {
        return new AutomotiveBuilderImpl();
    }

    private static final class AutomotiveBuilderImpl extends AutomotiveBuilder<Automotive, AutomotiveBuilderImpl> {
        private AutomotiveBuilderImpl() {
        }

        protected AutomotiveBuilderImpl self() {
            return this;
        }

        public Automotive build() {
            return new Automotive(this);
        }
    }

    public abstract static class AutomotiveBuilder<C extends Automotive, B extends AutomotiveBuilder<C, B>> extends CarBuilder<C, B> {
        private Long identity;
        private String bodyType;
        private String fuelType;
        private String gearbox;

        AutomotiveBuilder() {
        }

        public B identity(Long identity) {
            this.identity = identity;
            return self();
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

        protected abstract B self();

        public abstract C build();
    }
}
