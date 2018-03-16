public class LowQualityLayer implements Layer {

    private final int length;
    private final String block = "V";

    public LowQualityLayer(int length) {
        this.length = length;
    }

    public String getRepresentation() {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<length; i++) {
            result.append(block);
        }

        return result.toString();
    }

    public boolean canHold(Layer layer) {

        if(layer.getLength() >= this.length)
            return false;
        return true;
    }

    public int getLength() {
        return length;
    }
}
