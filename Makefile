DEFAULT_GOAL := build-run
install:
	make -C app install
clean:
	make -C app clean
build:
	make -C app build
run:
	make -C app run-dist
test:
	make -C app test
lint:
	make -C app lint

