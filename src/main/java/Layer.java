public interface Layer {

    String getRepresentation();

    int getLength();

    boolean canHold(Layer layer);

}
