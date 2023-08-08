package com.example.adapter_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdapterPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdapterPatternApplication.class, args);

		// Client code using the adapter
		LegacyPrinter legacyPrinter = new LegacyPrinter();
		PrinterAdapter printerAdapter = new PrinterAdapter(legacyPrinter);
		Client client = new Client(printerAdapter);

		client.print("Hello, Adapter Pattern!");

		// Output will be:
		// Legacy Printer: Hello, Adapter Pattern!
	}
}

interface IPrinter {
    void printText(String text);
}

class LegacyPrinter {
    void print(String text) {
        System.out.println("Legacy Printer: " + text);
    }
}

class PrinterAdapter implements IPrinter {
    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void printText(String text) {
        legacyPrinter.print(text);
    }
}

class Client {
    private IPrinter printer;

    public Client(IPrinter printer) {
        this.printer = printer;
    }

    public void print(String text) {
        printer.printText(text);
    }
}
