package org.floens.chan.chan;

/**
 * Created by jgworks on 10/22/14.
 */
public interface ChanUrlsInterface {
    void loadScheme(boolean useHttps);

    String getChan();

    String getCatalogUrl(String board);

    String getPageUrl(String board, int pageNumber);

    String getThreadUrl(String board, int no);

    String getCaptchaChallengeUrl();

    String getCaptchaImageUrl(String challenge);

    String getImageUrl(String board, String code, String extension);

    String getThumbnailUrl(String board, String code, String extension);

    String getSpoilerUrl();

    String getCustomSpoilerUrl(String board, int value);

    String getCountryFlagUrl(String countryCode);

    String getTrollCountryFlagUrl(String countryCode);

    String getBoardsUrl();

    String getReplyUrl(String board);

    String getDeleteUrl(String board);

    String getBoardUrlDesktop(String board);

    String getThreadUrlDesktop(String board, int no);

    String getCatalogUrlDesktop(String board);

    String getPassUrl();

    String getReportUrl(String board, int no);
}
