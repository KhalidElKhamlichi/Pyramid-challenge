package PyramidLayers;

public class HighQualityLayer extends Layer {

    private final String block = "X";

    HighQualityLayer(int length) {
        super(length);
        super.setBlock(block);
    }

    public boolean canHold(Layer layer) {
        return layer.getLength() <= this.length;
    }

}
