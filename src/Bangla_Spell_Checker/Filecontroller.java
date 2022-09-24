package Bangla_Spell_Checker;

public class Filecontroller {
	String path = null;

	Filecontroller(String string) {
		if (string.charAt(0) == '\u0985') {
			path = "File\\অ.txt";
		} else if (string.charAt(0) == '\u0986') {
			path = "File\\আ.txt";
		} else if (string.charAt(0) == '\u0987') {
			path = "File\\ই.txt";
		} else if (string.charAt(0) == '\u0988') {
			path = "File\\ঈ.txt";
		} else if (string.charAt(0) == '\u0989') {
			path = "File\\উ.txt";
		} else if (string.charAt(0) == '\u098A') {
			path = "File\\ঊ.txt";
		} else if (string.charAt(0) == '\u098B') {
			path = "File\\ঋ.txt";
		} else if (string.charAt(0) == '\u098F') {
			path = "File\\এ.txt";
		} else if (string.charAt(0) == '\u0990') {
			path = "File\\ঐ.txt";
		} else if (string.charAt(0) == '\u0993') {
			path = "File\\ও.txt";
		} else if (string.charAt(0) == '\u0994') {
			path = "File\\ঔ.txt";
		} else if (string.charAt(0) == '\u0995') {
			path = "File\\ক.txt";
		} else if (string.charAt(0) == '\u0996') {
			path = "File\\খ.txt";
		} else if (string.charAt(0) == '\u0997') {
			path = "File\\গ.txt";
		} else if (string.charAt(0) == '\u0998') {
			path = "File\\ঘ.txt";
		} else if (string.charAt(0) == '\u0999') {
			path = "File\\ঙ.txt";
		} else if (string.charAt(0) == '\u099A') {
			path = "File\\চ.txt";
		} else if (string.charAt(0) == '\u099B') {
			path = "File\\ছ.txt";
		} else if (string.charAt(0) == '\u099C') {
			path = "File\\জ.txt";
		} else if (string.charAt(0) == '\u099D') {
			path = "File\\ঝ.txt";
		} else if (string.charAt(0) == '\u099E') {
			path = "File\\ঞ.txt";
		} else if (string.charAt(0) == '\u099F') {
			path = "File\\ট.txt";
		} else if (string.charAt(0) == '\u09A0') {
			path = "File\\ঠ.txt";
		} else if (string.charAt(0) == '\u09A1') {
			path = "File\\ড.txt";
		} else if (string.charAt(0) == '\u09A2') {
			path = "File\\ঢ.txt";
		} else if (string.charAt(0) == '\u09A3') {
			path = "File\\ণ.txt";
		} else if (string.charAt(0) == '\u09A4') {
			path = "File\\ত.txt";
		} else if (string.charAt(0) == '\u09A5') {
			path = "File\\থ.txt";
		} else if (string.charAt(0) == '\u09A6') {
			path = "File\\দ.txt";
		} else if (string.charAt(0) == '\u09A7') {
			path = "File\\ধ.txt";
		} else if (string.charAt(0) == '\u09A8') {
			path = "File\\ন.txt";
		} else if (string.charAt(0) == '\u09AA') {
			path = "File\\প.txt";
		} else if (string.charAt(0) == '\u09AB') {
			path = "File\\ফ.txt";
		} else if (string.charAt(0) == '\u09AC') {
			path = "File\\ব.txt";
		} else if (string.charAt(0) == '\u09AD') {
			path = "File\\ভ.txt";
		} else if (string.charAt(0) == '\u09AE') {
			path = "File\\ম.txt";
		} else if (string.charAt(0) == '\u09AF') {
			path = "File\\য.txt";
		} else if (string.charAt(0) == '\u09B0') {
			path = "File\\র.txt";
		} else if (string.charAt(0) == '\u09B2') {
			path = "File\\ল.txt";
		} else if (string.charAt(0) == '\u09B6') {
			path = "File\\শ.txt";
		} else if (string.charAt(0) == '\u09B7') {
			path = "File\\ষ.txt";
		} else if (string.charAt(0) == '\u09B8') {
			path = "File\\স.txt";
		} else if (string.charAt(0) == '\u09B9') {
			path = "File\\হ.txt";
		} else if (string.charAt(0) == '\u09CE') {
			path = "File\\ৎ.txt";
		} else if (string.charAt(0) == '\u09DC') {
			path = "File\\ড়.txt";
		} else if (string.charAt(0) == '\u09DD') {
			path = "File\\ঢ়.txt";
		} else if (string.charAt(0) == '\u09DF') {
			path = "File\\য়.txt";
		} else if (string.charAt(0) == '\u0982') {
			path = "File\\ং.txt";
		} else if (string.charAt(0) == '\u0983') {
			path = "File\\ঃ.txt";
		} else if (string.charAt(0) == '\u0981') {
			path = "File\\◌ঁ.txt";
		}
	}

	public String pathName() {
		return path;
	}
}