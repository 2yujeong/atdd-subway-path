package wooteco.subway.domain;

import java.util.List;

public class Section {

    private Long id;
    private long lineId;
    private long upStationId;
    private long downStationId;
    private int distance;
    private Long lineOrder;

    public Section() {
    }

    public Section(Long id, long lineId, long upStationId, long downStationId, int distance,
                   Long lineOrder) {
        this.id = id;
        this.lineId = lineId;
        this.upStationId = upStationId;
        this.downStationId = downStationId;
        this.distance = distance;
        this.lineOrder = lineOrder;
    }

    public Long getId() {
        return id;
    }

    public long getLineId() {
        return lineId;
    }

    public long getUpStationId() {
        return upStationId;
    }

    public long getDownStationId() {
        return downStationId;
    }

    public List<Long> getAllStations() {
        return List.of(upStationId, downStationId);
    }

    public int getDistance() {
        return distance;
    }

    public Long getLineOrder() {
        return lineOrder;
    }

    public boolean isSameId(Long id) {
        return this.id.equals(id);
    }

    public boolean isSameUpStationId(long stationId) {
        return upStationId == stationId;
    }

    public boolean isSameDownStationId(long stationId) {
        return downStationId == stationId;
    }

    public boolean hasStationId(long stationId) {
        return upStationId == stationId || downStationId == stationId;
    }

    public long getOppositeStation(long stationId) {
        if (upStationId == stationId) {
            return downStationId;
        }
        return upStationId;
    }
}
