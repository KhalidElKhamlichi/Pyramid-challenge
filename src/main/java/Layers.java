import java.util.ArrayList;
import java.util.List;

public class Layers {

    private List<Layer> layers = new ArrayList<Layer>();

    public void add(Layer layer) {
        layers.add(layer);
        checkCollapse();
    }

    private void checkCollapse() {
        if(layers.size() < 2)
            return;

        Layer recentLayer = layers.get(layers.size()-1);
        Layer previousLayer = layers.get(layers.size() - 2);

        if(!previousLayer.canHold(recentLayer))
            layers.remove(previousLayer);
    }

    public String print() {
        StringBuilder result = new StringBuilder();

        for(int i=layers.size()-1; i>=0; i--) {
            result.append(wrapLayer(layers.get(i)));
            if(i != 0)
                result.append("\n");
        }
        return result.toString();
    }

    private String wrapLayer(Layer layer) {
        StringBuilder result = new StringBuilder();

        int previousLayerIndex = layers.indexOf(layer) - 1;

        if(previousLayerIndex < 0) {
            return layer.getRepresentation();
        }

        Layer previousLayer = layers.get(previousLayerIndex);

        int sizeDiff = previousLayer.getLength() - layer.getLength();
        int numberOfEmptyBlocks = layers.get(0).getLength() - previousLayer.getLength();

        for (int i=0; i<numberOfEmptyBlocks/2; i++) {
            result.append(" ");
        }

        for (int i=0; i<sizeDiff/2; i++) {
            result.append("_");
        }

        result.append(layer.getRepresentation());

        for (int i=0; i<sizeDiff/2; i++) {
            result.append("_");
        }

        for (int i=0; i<numberOfEmptyBlocks/2; i++) {
            result.append(" ");
        }

        return result.toString();
    }
}
