package br.pro.hashi.ensino.desagil.aps.model;

public class XnorGate extends Gate {
    private final NandGate Nand1;
    private final NandGate Nand2;
    private final NandGate Nand3;
    private final NandGate Nand5;


    public XnorGate() {
        super("XnorGate", 2);
        Nand1 = new NandGate();
        Nand2 = new NandGate();
        Nand3 = new NandGate();
        NandGate nand4 = new NandGate();
        Nand5 = new NandGate();


        // Logica
        Nand2.connect(1, Nand1);
        Nand3.connect(0, Nand1);
        nand4.connect(0, Nand2);
        nand4.connect(1, Nand3);

        // Negando
        Nand5.connect(0, nand4);
        Nand5.connect(1, nand4);
    }


    @Override
    public boolean read() {
        return Nand5.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex > 1 || inputIndex < 0) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        if (inputIndex == 0) {
            Nand1.connect(0, emitter);
            Nand2.connect(0, emitter);
        } else {
            Nand1.connect(1, emitter);
            Nand3.connect(1, emitter);
        }
    }
}
