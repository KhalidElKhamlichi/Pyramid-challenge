package PyramidLayers;

public class LayerFactory {

    private static final int SLAVES_PER_BLOCk = 50;
    private static final int BUDGET_FOR_HIGHQUALITY = 2;

    public static Layer getLayer(String input) {
        String[] splitInput = input.split(", ");

        int numberOfSlaves = Integer.parseInt(splitInput[0].split(" ")[0]);

        int budget = Integer.parseInt(splitInput[1].split(" ")[0]);

        int numberOfBlocks = numberOfSlaves / SLAVES_PER_BLOCk;
        if(numberOfBlocks == budget / BUDGET_FOR_HIGHQUALITY)
            return new HighQualityLayer(numberOfBlocks);
        else
            return new LowQualityLayer(numberOfBlocks);
    }
}
