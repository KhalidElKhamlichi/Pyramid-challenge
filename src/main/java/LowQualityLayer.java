public class LowQualityLayer extends Layer {

    private final String block = "V";

    public LowQualityLayer(int length) {
        super(length);
        super.setBlock(block);
    }


    public boolean canHold(Layer layer) {
        if(layer.getLength() >= this.length)
            return false;
        return true;
    }

}
