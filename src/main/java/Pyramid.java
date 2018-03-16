public class Pyramid {

    private Layers layers = new Layers();

    public void addLayer(String s) {
        Layer layer = LayerFactory.getLayer(s);
        layers.add(layer);
    }

    public String print() {
        return layers.print();
    }
}
