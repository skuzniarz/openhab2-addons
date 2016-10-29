package org.openhab.binding.rf24.wifi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;

import pl.grzeslowski.smarthome.proto.common.Basic;
import pl.grzeslowski.smarthome.proto.sensor.Sensor;
import pl.grzeslowski.smarthome.rpi.wifi.Rf24;
import pl.grzeslowski.smarthome.rpi.wifi.help.Pipe;
import pl.grzeslowski.smarthome.rpi.wifi.help.rf24.Payload;
import pl.grzeslowski.smarthome.rpi.wifi.help.rf24.Pins;
import pl.grzeslowski.smarthome.rpi.wifi.help.rf24.Retry;

public class Rf24WiFi implements WiFi {
    private Logger logger = LoggerFactory.getLogger(Rf24WiFi.class);
    private static final ByteOrder ARDUINO_BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;

    private final pl.grzeslowski.smarthome.rpi.wifi.Wifi wifi;

    public Rf24WiFi(short ce, short cs, long spi, short delay, short number, short size) {
        wifi = new Rf24(new Pins(ce, cs, spi), new Retry(delay, number), new Payload(size));
    }

    @Override
    public void init() {
        logger.info("Init RF24");
        wifi.init();
    }

    @Override
    public void close() {
        logger.info("Close RF24");
        wifi.close();
    }

    @Override
    public boolean write(Pipe pipe, Sensor.SensorCommandMessage cmd) {
        logger.info("Write RF24");
        return wifi.write(pipe, cmd.toByteArray());
    }

    @Override
    public Optional<Basic.AckMessage> read(List<Pipe> pipes, ByteOrder byteOrder)
            throws InvalidProtocolBufferException {
        logger.info("Read RF24");
        ByteBuffer buffer = ByteBuffer.allocate(wifi.getPayload().getSize());
        buffer.order(byteOrder);
        final boolean read = wifi.read(pipes, buffer);
        if (read) {
            byte[] data = new byte[buffer.remaining()];
            buffer.get(data);
            final Basic.AckMessage ackMessage = Basic.AckMessage.parseFrom(data);
            return Optional.of(ackMessage);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Basic.AckMessage> read(Pipe pipe) throws InvalidProtocolBufferException {
        return read(Collections.singletonList(pipe), ARDUINO_BYTE_ORDER);
    }

    @Override
    public Optional<Basic.AckMessage> read(Pipe pipe, ByteOrder byteOrder) throws InvalidProtocolBufferException {
        return read(Collections.singletonList(pipe), byteOrder);
    }
}
