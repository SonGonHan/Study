import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

class FindBlocks {
    
    private static final Set<String> TypesOfBlocks = new LinkedHashSet<>();
    
    private static BufferedReader BlockReader;
    
    private static String SearchDate;
    
    public static void main(String[] args) throws IOException {
        String pathToFile = args[0];
        SearchDate = args[1];
        BlockReader = new BufferedReader(new FileReader(pathToFile));
        FindTypesOfBlocksOnSearchDate();
        System.out.println(TypesOfBlocks);
    }

    private static void FindTypesOfBlocksOnSearchDate() throws IOException {
        SkipHeadOfTable();
        String block;
        while ((block = BlockReader.readLine()).isEmpty()) {
            String[] blockInfo = getBlockInfo(block);
            if (checkBlockByDate(getDateOfBlock(blockInfo))) {
                insertTypeOfBlock(getTypeOfBlock(blockInfo));
            }
        }
    }

    private static String[] getBlockInfo(String block) {
        return block.split(",");
    }

    private static void SkipHeadOfTable() throws IOException {
        BlockReader.readLine();
    }

    private static String getDateOfBlock(String[] blockInfo) {
        return blockInfo[1].split(" ")[2];
    }

    private static boolean checkBlockByDate(String dateOfBlock) {
        return SearchDate.equals(dateOfBlock);
    }

    private static String getTypeOfBlock(String[] blockInfo) {
        return blockInfo[8];
    }

    private static void insertTypeOfBlock(String Type) {
        TypesOfBlocks.add(Type);
    }

}