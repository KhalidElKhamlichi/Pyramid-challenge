package PyramidLayers;

import java.util.ArrayList;
import java.util.List;

public class Layers {

    private final List<Layer> layers = new ArrayList<Layer>();

    private final String EMPTY_BLOCK = " ";
    private final String FILLER_BLOCK = "_";

    public void add(String inputLayer) {
        Layer layer = LayerFactory.getLayer(inputLayer);
        layers.add(layer);
        checkCollapse();
    }

    private void checkCollapse() {
        if(layers.size() == 1)
            return;

        Layer recentLayer = layers.get(layers.size()-1);
        Layer previousLayer = layers.get(layers.size() - 2);

        if(!previousLayer.canHold(recentLayer))
            layers.remove(previousLayer);
    }

    public String print() {
        StringBuilder result = new StringBuilder();

        for(int i=layers.size()-1; i>=0; i--) {

            String initialLayerRepresentation = layers.get(i).getRepresentation();

            String wrappedLayerRepresentation = wrapLayerWithFillerBlocks(layers.get(i), initialLayerRepresentation);
            wrappedLayerRepresentation = wrapLayerWithEmptyBlocks(layers.get(i), wrappedLayerRepresentation);

            result.append(wrappedLayerRepresentation);

            if(i != 0)
                result.append("\n");
        }
        return result.toString();
    }

    private String wrapLayerWithEmptyBlocks(Layer layer, String representation) {
        StringBuilder result = new StringBuilder();

        int previousLayerIndex = layers.indexOf(layer) - 1;

        if(previousLayerIndex < 0) {
            return representation;
        }

        Layer previousLayer = layers.get(previousLayerIndex);

        int numberOfEmptyBlocks = layers.get(0).getLength() - previousLayer.getLength();

        for (int i=0; i<numberOfEmptyBlocks/2; i++) {
            result.append(EMPTY_BLOCK);
        }

        result.append(representation);

        for (int i=0; i<numberOfEmptyBlocks/2; i++) {
            result.append(EMPTY_BLOCK);
        }

        return result.toString();
    }

    private String wrapLayerWithFillerBlocks(Layer layer, String representation) {
        StringBuilder result = new StringBuilder();

        int previousLayerIndex = layers.indexOf(layer) - 1;

        if(previousLayerIndex < 0) {
            return representation;
        }

        Layer previousLayer = layers.get(previousLayerIndex);

        int sizeDiff = previousLayer.getLength() - layer.getLength();

        for (int i=0; i<sizeDiff/2; i++) {
            result.append(FILLER_BLOCK);
        }

        result.append(representation);

        for (int i=0; i<sizeDiff/2; i++) {
            result.append(FILLER_BLOCK);
        }


        return result.toString();
    }
}
