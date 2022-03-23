package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(value = {CarDto.CLASS_TYPE_NAME})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = CarDto.CLASS_TYPE_NAME, defaultImpl = CarDto.class)
@JsonSubTypes({@JsonSubTypes.Type(value = AutomotiveDto.class, name = CarDto.AUTOMOTIVE_NAME),
        @JsonSubTypes.Type(value = BusDto.class, name = CarDto.BUS_NAME),
        @JsonSubTypes.Type(value = TruckDto.class, name = CarDto.TRUCK_NAME)})
public class CarDto {

    public static final String CLASS_TYPE_NAME = "classType";
    public static final String AUTOMOTIVE_NAME = "automotive";
    public static final String BUS_NAME = "bus";
    public static final String TRUCK_NAME = "truck";

    private String plate;
    private String make;
    private String type;
    private Integer year;
    private String color;

    public CarDto() {
    }

    public CarDto(CarBuilder<?, ?> b) {
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
        } else if (!(o instanceof CarDto)) {
            return false;
        } else {
            CarDto other = (CarDto) o;
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
        return "CarDto(" + toField() + ")";
    }

    public static CarBuilder<?, ?> builder() {
        return new CarBuilderImpl();
    }

    private static final class CarBuilderImpl extends CarBuilder<CarDto, CarBuilderImpl> {
        private CarBuilderImpl() {
        }

        protected CarBuilderImpl self() {
            return this;
        }

        public CarDto build() {
            return new CarDto(this);
        }
    }

    public abstract static class CarBuilder<C extends CarDto, B extends CarBuilder<C, B>> {
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
