import java.util.Random;
import java.lang.Math;

public class wordSearch {
    private char puzzleGrid [][]; //2D character array that represents the grid
    private boolean[][] solution; //2D boolean array of the same size as grid
    private String[] words; // array of words that you want to hide from puzzle grid


    public void generate(String[] w) { 
        for(int i = 0; i < w.length; i ++){
            w[i] = w[i].toLowerCase(); // converts inputed words to lowercase 
        }

        this.words = w;
        char[][] wordChars = initializeGrid(); // creates character arrays to store character words 
        
        for(int i = 0; i < wordChars.length; i++){ 
            individualLetter(wordChars, i);  //calls method to hide each word in the grid
        }

        fillGrid(); // calls method

    }

    private void fillGrid() { //fills remaining empty cells with empty letters

        for (int i = 0; i < puzzleGrid.length; i++) {
            for (int j = 0; j < puzzleGrid[i].length; j++) {
                Random rand = new Random();
                
                if (puzzleGrid[i][j] == '\u0000') { //fills with random lowercase letter
                    puzzleGrid[i][j] = (char)(rand.nextInt(26) + 97);
                }
            }
        }
    }

    public String puzzleToString(){ //converts grid into a formatted string
        String res = " ";
        for(int i = 0; i < puzzleGrid.length; i++){
            for(int j = 0; j < puzzleGrid[i].length; j ++){
                res += " " + puzzleGrid[i][j] + " " ;

            }
            res += "\r\n";
        }
        return res;
        
    }


    private void individualLetter(char[][] wordChars, int i) { //places word in grid and determines the direaction of the word
        Random rand = new Random();
        int direction = rand.nextInt(3);
        int[] pos = {0,0};

        if(direction == 0){ //horizontal 
            boolean placed = false;
            int idx = 0;

            while (!placed && idx < 100) {
                int maxBound = Math.max(0, puzzleGrid.length - 1);
                pos[0] = rand.nextInt(maxBound - wordChars[i].length + 1);
                pos[1] = rand.nextInt(maxBound - wordChars[i].length + 1);
                placed = true;
                
                for (int x = 0; x < wordChars[i].length; x++) {
                    if (puzzleGrid[pos[0] + x][pos[1]] != '\u0000' && puzzleGrid[pos[0] + x][pos[1]] != wordChars[i][x]) {
                        placed = false;
                        break;
                    }
                }

                idx++;
            }

            if (placed) {
                for (int j = 0; j < wordChars[i].length; j++) {
                    puzzleGrid[pos[0]][pos[1]] = wordChars[i][j];
                    solution[pos[0]][pos[1]] = true;
                    pos[0]++;
                }
            } 

        } else if (direction == 1) { //vertical
            boolean placed = false;
            int idx = 0;
            
            while (!placed && idx < 100) {
                int maxBound = Math.max(0, puzzleGrid.length - 1);
                pos[0] = rand.nextInt(maxBound - wordChars[i].length + 1);
                pos[1] = rand.nextInt(maxBound - wordChars[i].length + 1);
                placed = true;
                
                for (int j = 0; j < wordChars[i].length; j++) {
                    if (puzzleGrid[pos[0]][pos[1] + j] != '\u0000' && puzzleGrid[pos[0]][pos[1] + j] != wordChars[i][j]) {
                        placed = false;
                        break;
                    }
                }
                idx++;
            }
            
            if (placed) {
                for (int x = 0; x < wordChars[i].length; x++) {
                    puzzleGrid[pos[0]][pos[1]] = wordChars[i][x];
                    solution[pos[0]][pos[1]] = true;
                    pos[1]++;
                }

            }



        } else if (direction == 2){ //diagonal
            boolean placed = false;
            int idx = 0;
            
            while (!placed && idx < 100) {
                int maxBound = Math.max(0, puzzleGrid.length - 1);
                pos[0] = rand.nextInt(maxBound - wordChars[i].length + 1);
                pos[1] = rand.nextInt(maxBound - wordChars[i].length + 1);
                placed = true;
                
                for (int j = 0; j < wordChars[i].length; j++) {
                    if (puzzleGrid[pos[0] + j][pos[1] + j] != '\u0000' && puzzleGrid[pos[0] + j][pos[1] + j] != wordChars[i][j]) {
                        placed = false;
                        break;
                    }
                }
                idx++;


            }
            if (placed) {
                for (int x = 0; x < wordChars[i].length; x++) {
                    puzzleGrid[pos[0]][pos[1]] = wordChars[i][x];
                    solution[pos[0]][pos[1]] = true;
                    pos[1]++;
                    pos[0]++;
            
                }
            }
        }
        
    }


    private char[][] initializeGrid() { // determines size of the grid based on the length of the longest word
        int longesWordlength = 0;
        
        for(String word : words){
            if(word.length() > longesWordlength){
                longesWordlength = word.length();
            }
        }

        int gridSize = longesWordlength + 4;
        this.puzzleGrid = new char[gridSize][gridSize];
        this.solution = new boolean[gridSize][gridSize];

        char[][] wordChars = new char[words.length][];
        for(int i = 0; i < words.length; i++){
            wordChars[i] = words[i].toCharArray();
        }

        return wordChars;



    }


    public String toSolution() { //converts grid and solution arrays into string or X if unfilled

        String res = " ";
        for (int i = 0; i < puzzleGrid.length; i++) {
            for (int j = 0; j < puzzleGrid[i].length; j++) {
                if (solution[i][j]) {
                    res += " " + puzzleGrid[i][j] + " ";
                } else {
                    res += " X ";
                }
            }
            res += "\r\n";
        }
        return res;

    }

    
        
}
