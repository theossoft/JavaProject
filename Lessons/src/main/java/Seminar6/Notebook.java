package Seminar6;

import java.util.Objects;

public class Notebook {
    private String model;
    private String color;
    private Integer memory;
    private Integer warranty;

    public Notebook(String model, Integer memory, String color) {
        this.model = model;
        this.memory = memory;
        this.color = color;

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }
}
