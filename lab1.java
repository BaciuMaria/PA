class HelloWorld {
    public static int sum(int a, int b)
    {
        int add= a+b;
        return add;
    }
    public static void main(String[] args) {

        System.out.println("Hello World!"); 
        
        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        
        int n = (int) (Math.random() * 1_000_000);
        
        String bin="10101";
        int binaryNum= Integer.parseInt(bin, 2);
        int hexadecimalNum = Integer.decode("FF");
        int result = sum((n * 3),binaryNum);
        result= sum(result, hexadecimalNum );
        result= result * 6;

        while( restul > 10 )
        {
            int aux;
            while( restul > 0)
            { aux = aux + restul % 10;
              restul = restul / 10;
            }
            restul = aux;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
