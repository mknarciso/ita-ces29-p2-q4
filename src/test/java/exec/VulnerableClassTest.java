package exec;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import org.junit.Test;

public class VulnerableClassTest {
  private VulnerableClass vc = new VulnerableClass();

  @Test(expected = Exception.class)
  public void avoidParentDirectory() throws Exception {
    vc.vulnerableMethod("../write.txt");
  }

  @Test(expected = Exception.class)
  public void avoidSpecialChars() throws Exception {
    vc.vulnerableMethod("é.txt");
  }

  @Test(expected = Exception.class)
  public void invalidCharsInput() throws Exception {
    InputStream in1 = new ByteArrayInputStream("W\n".getBytes());
    InputStream in2 = new ByteArrayInputStream("Teste de especiais: ç.\n".getBytes());
    InputStream in3 = new ByteArrayInputStream("Q\n".getBytes());
    System.setIn(new SequenceInputStream(new SequenceInputStream(in1, in2), in3));
    vc.vulnerableMethod("write2.txt");
  }
  
  @Test(expected = Exception.class)
  public void bigFile() throws Exception {
    InputStream in1 = new ByteArrayInputStream("R\n".getBytes());
    InputStream in2 = new ByteArrayInputStream("Q\n".getBytes());
    System.setIn(new SequenceInputStream(in1, in2));
    vc.vulnerableMethod("read_big.txt");
  }
  
  @Test(expected = Exception.class)
  public void bigLine() throws Exception {
    String big = "Teste de entrada para o arquivo write.txt"
        + "Teste de entrada para o arquivo write.txt"
        + "Teste de entrada para o arquivo write.txt"
        + "Teste de entrada para o arquivo write.txt"
        + "Teste de entrada para o arquivo write.txt"
        + "Teste de entrada para o arquivo write.txt"
        + "Teste de entrada para o arquivo write.txt"
        + "Teste de entrada para o arquivo write.txt"
        + "Teste de entrada para o arquivo write.txt"
        + "Teste de entrada para o arquivo write.txt\n";
    InputStream in1 = new ByteArrayInputStream("W\n".getBytes());
    InputStream in2 = new ByteArrayInputStream(big.getBytes());
    InputStream in3 = new ByteArrayInputStream("Q\n".getBytes());
    System.setIn(new SequenceInputStream(
        new SequenceInputStream(in1, in2), in3));
    vc.vulnerableMethod("write.txt");
  }

  @Test
  public void wrongOption() throws Exception {
    final PrintStream oldStdout = System.out;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    InputStream in1 = new ByteArrayInputStream(
        "Invalid Input\n".getBytes());
    InputStream in2 = new ByteArrayInputStream("Q\n".getBytes());
    System.setIn(new SequenceInputStream(in1, in2));
    vc.vulnerableMethod("write2.txt");
    assertEquals("Digite a operacao desejada para realizar "
        + "no arquivo <R para ler um arquivo, W para "
        + "escrever em um arquivo, Q para encerrar>?"
        + " Opção inválida\nDigite a operacao desejada "
        + "para realizar no arquivo <R para ler um "
        + "arquivo, W para escrever em um arquivo, "
        + "Q para encerrar>? Closing program...\n",
        outContent.toString());
    System.setOut(oldStdout);
  }

  @Test
  public void testOk() throws Exception {
    InputStream in1 = new ByteArrayInputStream("R\n".getBytes());
    InputStream in2 = new ByteArrayInputStream("Q\n".getBytes());
    System.setIn(new SequenceInputStream(in1, in2));
    vc.vulnerableMethod("read.txt");
  }

  @Test
  public void testOk2() throws Exception {
    String in = "Teste de entrada para o arquivo write.txt\n";
    InputStream in1 = new ByteArrayInputStream("W\n".getBytes());
    InputStream in2 = new ByteArrayInputStream(in.getBytes());
    InputStream in3 = new ByteArrayInputStream("Q\n".getBytes());
    System.setIn(new SequenceInputStream(
        new SequenceInputStream(in1, in2), in3));
    vc.vulnerableMethod("write.txt");
  }
}
