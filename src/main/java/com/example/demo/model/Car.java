package com.example.demo.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Car {

    private String plate; // 19mzd78
    private String make; // mazda
    private String type; // rx7
    private Integer year; // 1978
    private String color; // green

    public Car() {
    }

    public Car(CarBuilder<?, ?> b) {
        this.plate = b.plate;
        this.make = b.make;
        this.type = b.type;
        this.year = b.year;
        this.color = b.color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Car)) {
            return false;
        } else {
            Car other = (Car) o;
            label1:
            {
                if (year == null) {
                    if (other.getYear() == null) break label1;
                } else if (year.equals(other.getYear())) break label1;
                else return false;
            }
            if (plate == null) {
                if (other.getPlate() != null) return false;
            } else if (!plate.equals(other.getPlate())) return false;
            label2:
            {
                if (make == null) {
                    if (other.getMake() == null) break label2;
                } else if (make.equals(other.getMake())) break label2;
                else return false;
            }
            if (type == null) {
                if (other.getType() != null) return false;
            } else if (!type.equals(other.getType())) return false;
            if (color == null) {
                if (other.getColor() != null) return false;
            } else if (!color.equals(other.getColor())) return false;
            return true;
        }
    }

    public String toField() {
        return "plate=" + plate + ", make=" + make + ", type=" + type + ", year=" + year + ", color=" + color;
    }

    public String toString() {
        return "Car(" + toField() + ")";
    }

    public static CarBuilder<?, ?> builder() {
        return new CarBuilderImpl();
    }

    private static final class CarBuilderImpl extends CarBuilder<Car, CarBuilderImpl> {
        private CarBuilderImpl() {
        }

        protected CarBuilderImpl self() {
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public abstract static class CarBuilder<C extends Car, B extends CarBuilder<C, B>> {
        private String plate;
        private String make;
        private String type;
        private Integer year;
        private String color;

        CarBuilder() {
        }

        public B plate(String plate) {
            this.plate = plate;
            return self();
        }

        public B make(String make) {
            this.make = make;
            return self();
        }

        public B type(String type) {
            this.type = type;
            return self();
        }

        public B year(Integer year) {
            this.year = year;
            return self();
        }

        public B color(String color) {
            this.color = color;
            return self();
        }

        protected abstract B self();

        public abstract C build();
    }
}
