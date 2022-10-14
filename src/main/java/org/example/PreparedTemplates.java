package org.example;

import java.util.Random;

public class PreparedTemplates {

    static String[] templates = {
            """
            ....**......**....
            ...*.*......*.*...
            ...*..........*...
            **.*..........*.**
            **.*.*..**..*.*.**
            ...*.*.*..*.*.*...
            ...*.*.*..*.*.*...
            **.*.*..**..*.*.**
            **.*..........*.**
            ...*..........*...
            ...*.*......*.*...
            ....**......**....
            """,
            """
            **........................**
            **........................**
            ..................**........
            .................*..*.......
            ..................**........
            ..............*.............
            .............*.*............
            ............*...*...........
            ............*..*............
            ............................
            ............*..*............
            ...........*...*............
            ............*.*.............
            .............*..............
            ........**..................
            .......*..*.................
            ........**..................
            **........................**
            **........................**
            """,
            """
            .....***...........***.....
            ....*...*.........*...*....
            ...**....*.......*....**...
            ..*.*.**.**.....**.**.*.*..
            .**.*....*.**.**.*....*.**.
            *....*...*..*.*..*...*....*
            ............*.*............
            **.......**.*.*.**.......**
            ............*.*............
            ......***.........***......
            ......*...*.........*......
            ......*.*....***...........
            ............*..*....**.....
            ...............*...........
            ...........*...*...........
            ...........*...*...........
            ...............*...........
            ............*.*............
            """,
            """
            ....*.*......**.............................
            .....**......**.............................
            .....*......................................
            ............................................
            ............................................
            ............................................
            ............................................
            ............................................
            ............................................
            ........................................*...
            .......................................*.*..
            .......................................*.*..
            ....................**................**.**.
            ....................**......................
            ......................................**.**.
            ..**..................................**.*..
            .*.*.......................................*
            .*........................................**
            **..........................................
            ............................................
            ..................................**........
            ..................................**....**..
            ...........**...........................*.*.
            ..........*.*.............................*.
            ..........*...............................**
            .........**.......................**........
            ..................................**........
            ............................................
            ............................................
            .............................*..............
            ............................*.*.............
            .............................*..............
            """,
            """
            **................................................**
            .*................................................*.
            .*.*.....................**.....................*.*.
            ..**........*............**............**.......**..
            ...........**..........................*.*..........
            ..........**.............................*..........
            ...........**..**......................***..........
            ....................................................
            ....................................................
            ....................................................
            ...........**..**......................***..........
            ..........**.............................*..........
            ...........**..........................*.*..........
            ..**........*............**............**.......**..
            .*.*.....................**.....................*.*.
            .*................................................*.
            **................................................**
            """,
            """
            ................................**.*...........................
            ...............................***.*......*.*..................
            ..............................*....*.*....*....................
            ...............................**......*.*...*.................
            ................................*...*..*..**...................
            ...................................*.**...*....................
            ..................................*.*................**........
            ..................................*.*................**........
            ...............................................................
            ...............................................................
            ...............................................................
            ...............................................................
            ...............................................................
            ...............................................................
            .............................................................**
            ....................................................**.......**
            .......................................*.........*.****........
            ..................................*...*****.....**.*...**......
            .................................*.*.......**....*..**.**......
            .................................*.......*.**.....******.......
            ..................................*........**......*...........
            ...................................*...****....................
            ........................................***....................
            ........................*.*.........**.........................
            ........................*.*.*......*.*.........................
            .......................*..**.*....**...........................
            ........................**...*.*.**.*..........................
            ........................**...**.*****..........................
            ............................*.**...**..........................
            ...........................*.*.................................
            ..**.*.........................................................
            .***.*......*.*................................................
            *....*.*....*..................................................
            .**......*.*...*...............................................
            ..*...*..*..**...........*.....................................
            .....*.**...*...........***....................................
            ....*.*.................*..*...................................
            ....*.*................*....*..................................
            ........................*......................................
            ...............................................................
            ........................*..*...................................
            .........................*.*...................................
            ...............................................................
            .....................*.........................................
            ....................***........................................
            ...................**.**.......................................
            .........*........**.*.....*...................................
            ....*...*****....**......**....................................
            ...*.*.......**..**.......**...................................
            ...*.......*.**................................................
            ....*........**................................................
            .....*...****..................................................
            ..........***..................................................
            ...............................................................
            ...............................................................
            ...............................................................
            ...........**..................................................
            ...........**..................................................
            """,
            """
            .....**...*........
            ....*..*..***......
            ....**.*.....*.....
            ......*.****.*.....
            ..***.*.*...*.**...
            .*..*..*...*..*.*..
            *.*..*...*.**....*.
            .*..........**.***.
            ..**.**.**...*.....
            ...*...*.....*.***.
            ...*...*......**..*
            .................**
            """,
            """
            .............*..**......*..***
            .....*...****.******....*..***
            .*****....*....*....***.......
            *......**.*......**.***..*.***
            .*****.***........****...*.***
            .....*..*..............*......
            ........**..........**.**.....
            ........**..........**.**.....
            .....*..*..............*......
            .*****.***........****...*.***
            *......**.*......**.***..*.***
            .*****....*....*....***.......
            .....*...****.******....*..***
            .............*..**......*..***
            """,
            """
            **............**..*....**..**.............
            **............*.**......**.**.............
            ...............*......*.*.................
            ...............***....**..................
            ..........................................
            ...............***....**..................
            ...............*......*.*.................
            **............*.**......**................
            **............**..*....**.................
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ...............................***...***..
            ..............................*...*.*...*.
            .............................*...**.**...*
            .............................*.**.....**.*
            ...............................*.......*..
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ..........................................
            ...............................**.....**..
            ...............................**.....**..
            """,
            """
            ..........*..................................................
            .........*.*........................**.......................
            ..*....***.*.....*...................*...*..*......*.....**..
            .*.*..*....**...*.*..................*.***..***...*.*....*...
            .*.*..*.**.......*....................*...**...*.*..*......*.
            **.**.*.*.*****.....*..................**...*..*.*.**.**..**.
            .*.*..*...*..*..*.......**...**...**....**.**..*.*..*.*.*....
            .*..**....**......***.**...**...**...***.....****.***.*...**.
            ..*..***..*..*.****...**...**...**...***.**..*....*.*....*..*
            ...**...*.*..*.....**...**...**...**......*............*...**
            .....**.*.**.*.**..*......................*........**.*......
            .....*.**.*..*.**....*.................**.*.*................
            ...........**.......**..................*..**................
            ......................................*.*....................
            ......................................**.....................
            """,
            """
            .......*.................*.......
            ......***...............***......
            .....**....***.....***....**.....
            ...**.*..***..*...*..***..*.**...
            ....*.*..*.*...*.*...*.*..*.*....
            .**.*.*.*.*....*.*....*.*.*.*.**.
            .**...*.*....*.....*....*.*...**.
            .***.*...*....*.*.*....*...*.***.
            **.........**.*.*.*.**.........**
            ............*.......*............
            .........**.*.......*.**.........
            ..........*...........*..........
            .......**.*...........*.**.......
            .......**...............**.......
            .......*.*.*.***.***.*.*.*.......
            ......**...*...*.*...*...**......
            ......*..*...*.*.*.*...*..*......
            .........**....*.*....**.........
            .....**....*...*.*...*....**.....
            .........*.**.*...*.**.*.........
            ..........*.*.*.*.*.*.*..........
            ............*..*.*..*............
            ...........*.*.....*.*...........
            """,
            """
            .........*.*..................
            ........*..*..................
            .......**.....................
            ......*...*...................
            .....***.*....................
            ..**..........................
            .*...*****.......****.....*..*
            *...*............*...*...*....
            *.....**.........*.......*...*
            ***...****........*..*...****.
            .*.......*....................
            .**...................**......
            .*.*..................**......
            .**..**.*........*.*..**......
            ..*.***.*...*.****.*..**......
            .........**.*.**..*...**...***
            ....******.**...****..**...***
            .....*....***......*..**...***
            ......**.....**..**...**......
            .......*..*.....****..**......
            ........*.*.**.....*..**......
            ......................**......
            ..............................
            ..................*..*...****.
            .................*.......*...*
            .................*...*...*....
            .................****.....*..*
            """,
            """
            .........*..........................
            ........*.*.........................
            ......***.*.........................
            .....*....**.*......................
            .....*.**...**......**..............
            ....**.*.**.........*.*.............
            .........*.*****......*..*.**.......
            ..*.**.**.*.....*....**.*.**.*......
            .....**.....****........*....*......
            *...*.*..*...*.*....**.*.****.**....
            *...*.*..**.*.**.**....*.*....*.*...
            .....**...***.**.*.***.*..***...*...
            ..*.**.**.**.............*.*..*.*.**
            ...........*......*.*.*.*..**.*.*.*.
            ....**.*.*.**......**.*.*.*...*.*.*.
            .....*.**.*..*.......*.**..****.**..
            .....*....*.*........*...**.........
            ....**....**........**...*..*.......
            ...........................**.......
            """,
            """
            ..............**....**....**...............................
            .............*..*.*....*.*..*..............................
            .............***..........***..............................
            ................**......**.................................
            ...............*..******..*................................
            ...............**........**................................
            ...........................................................
            ........*.............................**..........*........
            .......*...***......*.........*.......**.........*.*.......
            ........*.*****..........***...*...........................
            ............*...*.....*.*****.*..................*.........
            ............**....***.....*......................**........
            ............**....***....**...................*****........
            ...................*.....**...................**.**.....**.
            .................................................*......*.*
            .....................................................**.*.*
            .....................................................*.*.*.
            .......................................................*...
            ...................................***.........*.*...*..*..
            .......**..........................*..*........*..*.....*..
            .......**..............................*.......*.*..*...*..
            ...................................*..*.............*...*..
            ...................................***..................*..
            .....................................................*..*..
            ................................................*......*...
            .............................................**.**...*.*.*.
            .............................................*****...**.*.*
            .........*......................................**......*.*
            ........*.*.....................................*.......**.
            ...........................................................
            .**.......*.....................................*.*........
            *.*......**......................................*.........
            *.*.**...*****.............................................
            .*.*.*...**.**.............................................
            ...*......*................................................
            ..*..*.....................................................
            ..*........................................................
            ..*...*....................................................
            ..*...*..*.*......................................**.......
            ..*.....*..*......................................**.......
            ..*..*...*.*...............................................
            ...*.......................................................
            .*.*.*.....................................................
            *.*.**.....................................................
            *.*......*.................................................
            .**.....**.**...................**.....*...................
            ........*****...................**....***....**............
            ........**......................*.....***....**............
            .........*..................*.*****.*.....*...*............
            ...........................*...***..........*****.*........
            .......*.*.........**.......*.........*......***...*.......
            ........*..........**.............................*........
            ...........................................................
            ................................**........**...............
            ................................*..******..*...............
            .................................**......**................
            ..............................***..........***.............
            ..............................*..*.*....*.*..*.............
            ...............................**....**....**..............
            """,
            """
            ................*.................
            ..............*.*.*...............
            ............*.*.*.*.*.............
            ..........*.*.*.*.*.*.*...........
            ........*.*.*..**.*.*.*.*.........
            ......*.*.*.*......*..*.*.*.......
            ....*.*.*..*..........*.*.*.*.....
            .....**.*..............*..*.*.*...
            ...*...*..................*.**....
            ....***....................*...*..
            ..*.........................***...
            ...**...........................*.
            .*...*........................**..
            ..****.......................*...*
            *.............................***.
            .***.............................*
            *...*.......................****..
            ..**........................*...*.
            .*...........................**...
            ...***.........................*..
            ..*...*....................***....
            ....**.*..................*...*...
            ...*.*.*..*..............*.**.....
            .....*.*.*.*..........*..*.*.*....
            .......*.*.*..*......*.*.*.*......
            .........*.*.*.*.**..*.*.*........
            ...........*.*.*.*.*.*.*..........
            .............*.*.*.*.*............
            ...............*.*.*..............
            .................*................
            """,
            """
            ..............**......**......**...*.**..........
            ....*........*..*....*..*....*..*..**.*..........
            *..*.*....*...**..*...**..*...*.*.....*.**.......
            ****.*..******..******..******..******.*.*.......
            .....*.*.....*.*.....*.*.....*.*.....*.*......**.
            ..**.*.*.*.*...*.*.*...*.*.*...*.*.*...*.*.....*.
            .*.....*.*...*.*.*...*.*.*...*.*.*...*.*.*.*.**..
            .**......*.*.....*.*.....*.*.....*.*.....*.*.....
            .......*.*.******..******..******..******..*.****
            .......**.*.....*.*...*..**...*..**...*....*.*..*
            ..........*.**..*..*....*..*....*..*........*....
            ..........**.*...**......**......**..............
            """,
            """
            ..........****.............
            ..........*...*............
            ..........*................
            .**........*..*............
            **.**......................
            .****...*..................
            ..**...*.**........*....***
            ......*...*........*....*.*
            ..**...*.**........*....***
            .****...*..................
            **.**......................
            .**........*..*............
            ..........*................
            ..........*...*............
            ..........****.............
            """
    };


    public static boolean[][] getRandomTemplate(int width, int height) {
        Random random = new Random();
        int idx = random.nextInt(templates.length);
        return PatternParser.templateToSize(PatternParser.parse(templates[idx]), width, height);
    }

}
