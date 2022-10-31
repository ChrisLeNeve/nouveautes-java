public class Java16 {
    public static void main(String[] args) {
        TimelineEvent e = new TimelineEvent("Christopher et Nicolas",
                "group",
                "2022/10/jug-title.png");
        String HOST = "https://lemansjug.files.wordpress.com/";
        TimelineEventDto dto = new TimelineEventDto("New " + e.eventType,
                e.userName + " ont créé un " + e.eventType,
                HOST + e.imageId);

    }
}
class TimelineEvent {
    public String userName;
    public String eventType;
    public String imageId;

    public TimelineEvent(String userName, String eventType, String imageId) {
        this.userName = userName;
        this.eventType = eventType;
        this.imageId = imageId;
    }
}

record TimelineEventDto(String mainText, String secondaryText, String imageUrl) {
//immutable data classes. Generates constructor, equals + hashCode + toString methods, as well as getters.
//fields are private and final. Constructor implementation can be customised.
}