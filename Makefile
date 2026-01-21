SRC_DIR := src
BIN_DIR := bin
MAIN_CLASS := app.Main
INPUT_FILE := docs/scenario.txt

# Find all Java source files
SOURCES := $(shell find $(SRC_DIR) -name "*.java")

# Default target: compile and run
all: compile run

# Compile all Java files into bin directory
compile:
	@echo "Compiling Java sources..."
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(SOURCES)
	@echo "Compilation finished."

# Run the program with input file
run:
	@echo "Running simulation..."
	java -cp $(BIN_DIR) $(MAIN_CLASS) $(INPUT_FILE)

# Clean compiled files
clean:
	@echo "Cleaning compiled classes..."
	rm -rf $(BIN_DIR)
	@echo "Clean finished."
