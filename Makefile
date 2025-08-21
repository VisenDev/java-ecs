SRC=*java
BUILDDIR=build/


.PHONY: compile run

compile: $(SRC)
	mkdir -p $(BUILDDIR)
	javac -d $(BUILDDIR) $(SRC)

run: compile
	java -cp $(BUILDDIR) Main

clean:
	if [ -e $(BUILDDIR) ]; then trash $(BUILDDIR); fi
