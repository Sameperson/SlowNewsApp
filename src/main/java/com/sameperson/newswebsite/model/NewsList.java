package com.sameperson.newswebsite.model;

import java.util.ArrayList;


public class NewsList {

    private static NewsList instance;
    private ArrayList<NewsBean> listOfTheNews;

    public static NewsList getInstance() {
        if(instance == null) {
            instance = new NewsList();
        }
        return instance;
    }

    public synchronized void addNews(String name, String title, String body) {
        listOfTheNews.add(0, new NewsBean(name, title, body));
    }

    public ArrayList<NewsBean> getList() {
        return listOfTheNews;
    }

    public NewsBean findByName(String name) {
        for(NewsBean newsBean : listOfTheNews) {
            if(newsBean.getName().equals(name)) {
                return newsBean;
            }
        }
        return null;
    }

    protected NewsList() {
        listOfTheNews = new ArrayList<>();
        addNews("20160327-gravitational-waves", "New era in astronomy begins with gravitational wave detection", "This morning’s historic press conference " +
                "in Washington ushered in a new era of astronomy, in a very exciting way. The director of the National Science Foundation, astronomer" +
                " France C?rdova, led the discussion that announced the detection of gravitational waves from two merging black holes, the first such detection in history. \n" +
                "Einstein predicted that merging black holes should produce ripples in space-time in his General Theory of Relativity a" +
                " century ago. And the LIGO project, Laser Interferometer Gravitational-Wave Observatory, made the detection following a " +
                "generation of effort that went into the search. \n" +
                 "“We now have a whole new way to observe the universe,” said Kip Thorne, one of LIGO’s founders and the well-known expert on black holes and gravitation." +
                " “For the first time, we have detected a violent storm in the fabric of space and time.”\n" +
                "\n" +
                "The detection took place September 14, 2015, and was recorded by LIGO’s facilities in both Livingston, Louisiana, and Hanford, " +
                "Washington. The detection lasted 20 milliseconds, and suggests the merger of stellar black holes “weighing” about 29 and 36 solar masses, " +
                "lying some 1.3 billion light-years away, in the general direction of the southern sky, perhaps toward the area of the Magellanic Clouds. \n");
        addNews("20160327-tales-of-tilting-moon", "Tales of a tilting Moon hidden in its polar ice", "Home/News/Tales of a tilting Moon hidden in its polar ice\n" +
                "submit to reddit6\n" +
                "Tales of a tilting Moon hidden in its polar ice\n" +
                "The spin axis of the Moon has moved by at least 6°, and that motion is recorded in ancient lunar ice deposits.\n" +
                "By Planetary Science Institute, Tucson, Arizona  |  Published: Thursday, March 24, 2016\n" +
                "RELATED TOPICS: SOLAR SYSTEM | THE MOON\n" +
                "Moon\n" +
                "The same face of the Moon has not always pointed towards Earth. The spin axis of the Moon has moved by at least 6°, and that motion is recorded in " +
                "ancient lunar ice deposits, said Matthew Siegler of the Planetary Science Institute (PSI) in Tucson, Arizona.\n" +
                "\n" +
                "This motion is believed to have resulted from a warm, low-density region of the lunar mantle below the dark patch of lunar mare called Oceanus Procellarum. " +
                "The same heat source that caused the volcanic mare to form also warmed the mantle. This is the first physical evidence that the Moon underwent such a dramatic" +
                " change in orientation and implies that the ice on the Moon is billions of years old.\n" +
                "\n" +
                "The new findings help explain the earliest dynamical and thermal history of the Moon and shed light on the origin of lunar water.");
        addNews("20160327-charon-ocean", "Pluto's largest moon may have once had an ocean", "Images from NASA’s New Horizons mission suggest " +
                "that Charon once had a subsurface ocean that has long since frozen and expanded, pushing out on the moon’s surface and causing it to " +
                "stretch and fracture on a massive scale.\n" +
                "\n" +
                "The side of Charon viewed by the passing New Horizons spacecraft in July 2015 is characterized by a system of “pull apart” " +
                "tectonic faults, which are expressed as ridges, scarps, and valleys — the latter sometimes reaching more than 4 miles (6.5 kilometers) " +
                "deep. Charon’s tectonic landscape shows that somehow the moon expanded in its past, and its surface fractured as it stretched.");
        addNews("20160327-pluto-atmosphere-confounds-researchers", "Pluto's atmosphere confounds researchers", "Observations by NASA's New Horizons spacecraft, combined " +
                        "with new modeling of long-term trends, suggest that Pluto's atmosphere is far more dynamic than anyone imagined.\n" +
                        "Every since its discovery in June 1988, Pluto's tenuous atmosphere has been a source of frequent discussion and debate " +
                        "among outer-planet specialists. Pluto is so cold, about 45 Kelvin (-380 Fahrenheit) that the frozen nitrogen, " +
                        "methane, and carbon monoxide on its surface sublimate (convert directly to gas) only very slowly. Moreover, given " +
                        "Pluto's strongly eccentric orbit and that it swung closest to the Sun (perihelion) in 1989, many researchers believed " +
                        "that what little gas surrounded this little world would all soon freeze and precipitate onto the surface. In fact, the " +
                        "prospect of a soon-to-be-airless Pluto became a compelling reason for NASA to fund and launch New Horizons.\n"
        );
        addNews("20160327-dark-comet-flyby", "Dark comet's flyby of Earth observed with radar and infrared", "Astronomers were watching " +
                "when comet P/2016 BA14 flew past Earth on 22 March. At the time of its closest approach, the comet was about 2.2 million miles " +
                "(3.5 million kilometres) away, making it the second closest flyby of a comet in recorded history next to comet D/1770 L1 (Lexell)" +
                " in 1770. Radar images from the flyby indicate that the comet is about 3,000 feet (1 kilometre) in diameter.\n" +
                "The scientists used the Goldstone Solar System Radar in California's Mojave Desert to track the comet. \"We were able to obtain " +
                "very detailed radar images of the comet nucleus over three nights around the time of closest approach,\" said Shantanu Naidu, a " +
                "postdoctoral researcher at NASA's Jet Propulsion Laboratory in Pasadena, California, who works with the radar team and led the " +
                "observations during the comet's flyby. We can see surface features as small as 8 metres per pixel.");
    }

}
