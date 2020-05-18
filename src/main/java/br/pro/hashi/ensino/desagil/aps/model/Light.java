package br.pro.hashi.ensino.desagil.aps.model;

import java.awt.*;

public class Light implements Receiver {
    private Color color;
    private Emitter emitter;
    private Color offColor;

    public Light(int r, int g, int b, int rOff, int gOff, int bOff) {
        color = new Color(r, g, b);
        offColor = new Color(rOff, gOff, bOff);
        emitter = null;
    }

    public Color getColor() {
        if (emitter != null && emitter.read()) {
            return color;
        }
        return offColor;
    }

    public void setColor(Color color) {
        if (emitter != null && emitter.read()) {
            this.color = color;
            return;
        }
        this.offColor = color;
        return;
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex != 0) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        this.emitter = emitter;
    }
}
