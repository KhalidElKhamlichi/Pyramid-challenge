import PyramidLayers.Layers;

public class Pyramid {

    private Layers layers = new Layers();

    public void addLayer(String layer) {
        layers.add(layer);
    }

    public String print() {
        return layers.print();
    }
}
