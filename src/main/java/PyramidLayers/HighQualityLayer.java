package PyramidLayers;

public class HighQualityLayer extends Layer {

    private final String block = "X";

    public HighQualityLayer(int length) {
        super(length);
        super.setBlock(block);
    }

    public boolean canHold(Layer layer) {
        if(layer instanceof LowQualityLayer)
            return true;

        if(layer.getLength() > this.length)
            return false;

        return true;
    }

}
