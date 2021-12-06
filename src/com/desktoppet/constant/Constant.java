package com.desktoppet.constant;

/**
 * Description: constants and centralized management
 *
 * @author Shengliang Yu
 */
public class Constant {

    public static class ImageShow {
        /**
         * Body height and width
         */
        public static final int ImageHeight = 200;
        public static final int ImageWidth = 200;

        private static final String prefix = "/com/desktoppet/img/";

        // Main Animation
        public static final String mainImage = prefix + "play.gif";
        // Bath
        public static final String bathImage = prefix + "bath.gif";
        // Bye
        public static final String byeImage = prefix + "byebye.gif";
        // Icon
        public static final String iconImage = prefix + "icon.jpeg";
        // Emotion increase
        public static final String rotatingcupImage = prefix + "rotating cup.gif";
        // Emotion increase
        public static final String emotionIncreasingImage = prefix + "cloud.jpeg";

        public static class ItemImage {
            // Food list - Egg
            public static final String eggImage = prefix + "foods/egg.jpeg";
            // Food list - Milk
            public static final String milkImage = prefix + "foods/milk.jpeg";
            // Bath list - Soap
            public static final String soapImage = prefix + "bath/soap.jpeg";
        }

    }

    public static class UserInterface {
        /**
         * Action runtime
         */
        public static final int ActionRunTime = 4;

        /**
         * The duration of the talking message box
         */
        public static final int SayingRunTime = 5;

        /**
         * Nagging
         */
        public static final String[] selfTalking = {
                "Hey~",
                "Click me~",
                "I LOVE YOU",
                "What are you doing now?",
                "I'm hungry, please get me something to eat",
        };
    }

}
