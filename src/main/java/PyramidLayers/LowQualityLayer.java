package PyramidLayers;

public class LowQualityLayer extends Layer {

    private final String block = "V";

    LowQualityLayer(int length) {
        super(length);
        super.setBlock(block);
    }

    public boolean canHold(Layer layer) {
        return layer.getLength() < this.length;
    }

}
