/*
 * Clover - 4chan browser https://github.com/Floens/Clover/
 * Copyright (C) 2014  Floens
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.floens.chan.chan;

import org.floens.chan.core.ChanPreferences;

import java.util.Locale;

public class ChanUrls {
    private static String scheme;
    private static ChanUrlsInterface chanUrls = new InfinityChanUrls();

    public static void loadChan(String chan){
        switch (chan){
            case InfinityChanUrls.TAG:
                chanUrls = new InfinityChanUrls();
                break;
            case HalfChanUrls.TAG:
                chanUrls = new HalfChanUrls();
                break;
        }
    }

    public static String getChan(){
        return chanUrls.getChan();
    }

    public static void loadScheme(boolean useHttps) {
        chanUrls.loadScheme(useHttps);
    }

    public static String getCatalogUrl(String board) {
        return chanUrls.getCatalogUrl(board);
    }

    public static String getPageUrl(String board, int pageNumber) {
        return chanUrls.getPageUrl(board, pageNumber);
    }

    public static String getThreadUrl(String board, int no) {
        return chanUrls.getThreadUrl(board, no);
    }

    public static String getCaptchaChallengeUrl() {
        return chanUrls.getCaptchaChallengeUrl();
    }

    public static String getCaptchaImageUrl(String challenge) {
        return chanUrls.getCaptchaImageUrl(challenge);
    }

    public static String getImageUrl(String board, String code, String extension) {
        return chanUrls.getImageUrl(board, code, extension);
    }

    public static String getThumbnailUrl(String board, String code, String extension) {
        return chanUrls.getThumbnailUrl(board, code, extension);
    }

    public static String getSpoilerUrl() {
        return chanUrls.getSpoilerUrl();
    }

    public static String getCustomSpoilerUrl(String board, int value) {
        return chanUrls.getCustomSpoilerUrl(board, value);
    }

    public static String getCountryFlagUrl(String countryCode) {
        return chanUrls.getCountryFlagUrl(countryCode);
    }

    public static String getTrollCountryFlagUrl(String countryCode) {
        return chanUrls.getTrollCountryFlagUrl(countryCode);
    }

    public static String getBoardsUrl() {
        return chanUrls.getBoardsUrl();
    }

    public static String getReplyUrl(String board) {
        return chanUrls.getReplyUrl(board);
    }

    public static String getDeleteUrl(String board) {
        return chanUrls.getDeleteUrl(board);
    }

    public static String getBoardUrlDesktop(String board) {
        return chanUrls.getBoardUrlDesktop(board);
    }

    public static String getThreadUrlDesktop(String board, int no) {
        return chanUrls.getThreadUrlDesktop(board, no);
    }

    public static String getCatalogUrlDesktop(String board) {
        return chanUrls.getCatalogUrlDesktop(board);
    }

    public static String getPassUrl() {
        return chanUrls.getPassUrl();
    }

    public static String getReportUrl(String board, int no) {
        return chanUrls.getReportUrl(board, no);
    }
}
