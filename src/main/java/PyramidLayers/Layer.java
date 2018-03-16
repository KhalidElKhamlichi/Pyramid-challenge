package PyramidLayers;

public abstract class Layer {

    protected final int length;
    private String block;

    public Layer(int length) {
        this.length = length;
    }

    public String getRepresentation() {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<length; i++) {
            result.append(block);
        }

        return result.toString();
    }

    public abstract boolean canHold(Layer layer);

    protected void setBlock(String block) {
        this.block = block;
    }

    public int getLength() {
        return length;
    }



}
