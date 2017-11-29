package game;

import org.testng.annotations.DataProvider;

class GameEngineData {

    @DataProvider
    public Object[][] drawTests(){
        return new Object[][]{
                {"0\n1\n3\n3\n3\nx\njozek\nczesiek\n0\n1\n2\n3\n4\n7\n5\n8\n6\n0\n1\n2\n3\n4\n7\n5\n8\n6\n\n0\n1\n2\n3\n4\n7\n5\n8\n6\n",
                        "draw1"},
        };
    }

    @DataProvider
    public Object[][] randomTests(){
        return new Object[][]{
                {"0\n1\n3\n3\n3\nx\njozek\nczesiek\n1\n0\n2\n4\n5\n3\n7\n6\n8\n1\n0\n2\n4\n5\n3\n7\n6\n8\n1\n0\n2\n4\n5\n3\n7\n6\n8\n",
                "random1"},
                {"0\n1\n3\n4\n3\nx\njozek\nczesiek\n1\n0\n2\n4\n5\n3\n7\n6\n8\n1\n0\n2\n4\n5\n3\n7\n6\n8\n1\n0\n2\n4\n5\n3\n7\n6\n8\n",
                        "random2"},
                {"0\n1\n3\n5\n3\nx\njozek\nczesiek\n1\n0\n2\n4\n5\n3\n7\n6\n8\n1\n0\n2\n4\n5\n3\n7\n6\n8\n1\n0\n2\n4\n5\n3\n7\n6\n8\n",
                        "random3"},
                {"0\n1\n4\n6\n3\nx\njozek\nczesiek\n" + createScenario(),
                        "random4"},
        };
    }

    @DataProvider
    public Object[][] inputs(){
        return new Object[][]{
                {"0\n1\n3\n3\n3\nx\njozek\nczesiek\n" + createScenario()},
                {"0\n1\n4\n3\n3\nx\njozek\nczesiek\n" + createScenario()},
                {"0\n1\n5\n3\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n6\n3\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n4\n4\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n4\n5\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n4\n6\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n6\n7\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n4\n6\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n3\n2\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n4\n7\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n10\n15\n4\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n9\n13\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n7\n7\n5\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n4\n8\n3\nx\njozek\nczesiek\n1"+ createScenario()},
                {"0\n1\n9\n9\n4\nx\njozek\nczesiek\n1"+ createScenario()},
        };
    }

    private Object createScenario(){
        StringBuilder moves = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            moves.append((int) (Math.random() * i) / 3).append("\n");
        }
        return moves.toString();
    }
}