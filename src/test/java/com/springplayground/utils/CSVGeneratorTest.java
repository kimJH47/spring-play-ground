package com.springplayground.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.springplayground.domain.Category;

class CSVGeneratorTest {

	RandomCSVGenerator csvGenerator = new RandomCSVGenerator();

	@Test
	@DisplayName("")
	void test() throws Exception {
		//given
		LocalDateTime a = LocalDateTime.of(2023, 5, 11, 0, 0, 0);
		LocalDateTime b = LocalDateTime.of(2023, 5, 9, 0, 0, 0);
		//when
		long min = b.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long max = a.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

		List<LocalDateTime> times = new ArrayList<>();

		for (int i = 0; i < 1_000_000; i++) {
			long mili = ThreadLocalRandom.current().nextLong(min, max);
			LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(mili), ZoneId.systemDefault());
			times.add(localDateTime);
		}

		//then
		for (int i = 0; i < 10000; i++) {
			System.out.println(times.get(i));
		}

	}

	@Test
	@DisplayName("")
	void test2() throws Exception {
		//given
		ArrayList<String> list = new ArrayList<>();
		list.add("id");
		list.add("created_date");
		list.add("modified_date");
		list.add("brand_name");
		list.add("category");
		list.add("name");
		list.add("price");
		LocalDateTime min = LocalDateTime.of(2023, 1, 1, 0, 0, 0);
		LocalDateTime max = LocalDateTime.of(2023, 12, 30, 0, 0, 0);
		// String brandStrings = "Nike, Adidas, Apple, Samsung, Coca-Cola, McDonald's, Toyota, Honda, Sony, Microsoft, Amazon, Google, Facebook, Netflix, Pepsi, Lego, Volkswagen, BMW, Mercedes-Benz, Audi, Puma, Gucci, Louis Vuitton, Chanel, Prada, Rolex, Tiffany & Co., H&M, Zara, Gap, Levi's, Calvin Klein, Tommy Hilfiger, Ralph Lauren, Under Armour, Lacoste, Converse, Vans, Starbucks, Dunkin' Donuts, Subway, KFC, Burger King, Pizza Hut, Domino's, Taco Bell, Walmart, Target, Best Buy, Home Depot, IKEA, Costco, Lowe's, Whole Foods, Trader Joe's, Walgreens, CVS, Disney, Warner Bros., Universal Studios, Marvel, DC Comics, Nintendo, PlayStation, Xbox, Canon, Nikon, GoPro, Adobe, HP, Dell, Lenovo, Intel, AMD, Netflix, Hulu, Spotify, Apple Music, Google Play Music, Amazon Prime Music, TikTok, Snapchat, Instagram, Twitter, Pinterest, LinkedIn, WhatsApp, Telegram, Slack, Zoom, Skype, Twitch, YouTube, Reddit, Tumblr, Pinterest";
		String[] br = {"Nike", "Adidas", "Calvin Klein", "Levi's", "Gucci", "H&M", "Zara", "Ralph Lauren",
			"Tommy Hilfiger", "Prada", "Versace", "Balenciaga", "Dolce & Gabbana", "Fendi", "Puma", "Under Armour",
			"Burberry", "ASOS", "Vans", "Reebok"};
		String[] arr = {"Striped T-shirt", "Denim Jeans", "Leather Jacket", "Floral Dress", "Plaid Shirt",
			"Cargo Pants", "Polka Dot Blouse", "Khaki Shorts", "Wool Sweater", "Maxi Skirt", "Graphic Hoodie",
			"Velvet Blazer", "Ruffled Blouse", "Corduroy Pants", "Puffer Jacket", "Sequin Top", "Chiffon Skirt",
			"Striped Polo Shirt", "Linen Shorts", "Bomber Jacket", "Lace Camisole", "Faux Leather Leggings",
			"Chambray Shirt", "Turtleneck Sweater", "Wrap Dress", "Hawaiian Shirt", "Satin Slip Dress",
			"Checkered Scarf", "Cropped Flare Jeans", "Peasant Blouse", "Cargo Shorts", "Sequin Mini Skirt",
			"Oversized Cardigan", "Tuxedo Blouse", "Track Pants", "Off-Shoulder Top", "Houndstooth Blazer",
			"Knit Beanie", "Denim Overalls", "Paisley Maxi Dress", "Fleece Vest", "Varsity Jacket",
			"Pleated Midi Skirt", "Camouflage Pants", "Sheer Blouse", "Suede Skirt", "Trench Coat", "Striped Jumpsuit",
			"Pleather Jacket", "Pinafore Dress", "Slingback Heels", "Tweed Blazer", "Harem Pants", "Bell Sleeve Top",
			"Linen Blouse", "Cargo Jacket", "Tulle Skirt", "Racerback Tank", "Puffer Vest", "Gingham Dress",
			"Leather Leggings", "Floral Kimono", "Satin Pajama Set", "Ripped Skinny Jeans", "Tied-Up Crop Top",
			"Wool Peacoat", "Fringe Jacket", "Patchwork Denim", "Knit Poncho", "Velvet Maxi Dress", "Bow Tie Blouse",
			"Pleated Culottes", "Checkered Blouse", "Linen Romper", "Shearling Coat", "Striped Bodysuit",
			"Faux Fur Vest", "Polka Dot Wrap Dress", "Plaid Mini Skirt", "Tencel Jumpsuit", "Bomber Hoodie",
			"Knit Legwarmers", "Corduroy Overalls", "Mesh Bodysuit", "Ruffled Maxi Dress", "Sequin Bolero",
			"Cargo Capris", "Oversized Flannel", "Velvet Leggings", "Trench Vest", "Striped Bandeau",
			"Utility Jumpsuit", "Denim Jacket", "Lace Bodysuit", "Gaucho Pants", "Tweed Skirt", "Quilted Coat",
			"Striped Turtleneck", "Camo Cargo Pants", "Leather Mini Skirt"};
		ArrayList<String> brands = new ArrayList<>(Arrays.asList(br));
		ArrayList<String> names = new ArrayList<>(Arrays.asList(arr));
		List<String> categories = Arrays.stream(Category.values())
			.map(Enum::toString)
			.collect(Collectors.toList());
		csvGenerator.createCSV(list, 2000000, 1, min, max, 1000000L, categories, brands, names);
		//when
		//then
	}

	@Test
	@DisplayName("")
	void test3() throws Exception {
		//given
		ArrayList<String> list = new ArrayList<>();
		list.add("id");
		list.add("created_date");
		list.add("modified_date");
		list.add("brand_name");
		list.add("category");
		list.add("name");
		list.add("price");

		String brandStrings = "Nike, Adidas, Apple, Samsung, Coca-Cola, McDonald's, Toyota, Honda, Sony, Microsoft, Amazon, Google, Facebook, Netflix, Pepsi, Lego, Volkswagen, BMW, Mercedes-Benz, Audi, Puma, Gucci, Louis Vuitton, Chanel, Prada, Rolex, Tiffany & Co., H&M, Zara, Gap, Levi's, Calvin Klein, Tommy Hilfiger, Ralph Lauren, Under Armour, Lacoste, Converse, Vans, Starbucks, Dunkin' Donuts, Subway, KFC, Burger King, Pizza Hut, Domino's, Taco Bell, Walmart, Target, Best Buy, Home Depot, IKEA, Costco, Lowe's, Whole Foods, Trader Joe's, Walgreens, CVS, Disney, Warner Bros., Universal Studios, Marvel, DC Comics, Nintendo, PlayStation, Xbox, Canon, Nikon, GoPro, Adobe, HP, Dell, Lenovo, Intel, AMD, Netflix, Hulu, Spotify, Apple Music, Google Play Music, Amazon Prime Music, TikTok, Snapchat, Instagram, Twitter, Pinterest, LinkedIn, WhatsApp, Telegram, Slack, Zoom, Skype, Twitch, YouTube, Reddit, Tumblr, Pinterest";
		String productStrings = "Striped T-shirt, Denim Jeans, Cotton Dress, Plaid Shirt, Leather Jacket, Knit Sweater, Floral Skirt, Cargo Pants, Silk Blouse, Wool Coat, Graphic Hoodie, Linen Shorts, Chiffon Blouse, Corduroy Pants, Sequined Dress, Cashmere Scarf, Embroidered Top, Velvet Blazer, Satin Slip Dress, Pleated Midi Skirt, Faux Leather Leggings, Tie-Dye Sweatshirt, Ruffled Blouse, Distressed Denim Jacket, Polka Dot Jumpsuit, Houndstooth Blazer, Cropped Hoodie, Embroidered Jeans, Suede Skirt, Fishnet Tights, Tropical Print Shirt, Puffer Vest, Turtleneck Sweater, Ruffled Maxi Dress, Checked Blouse, Fringe Jacket, Paisley Scarf, Knit Beanie, Embroidered Bomber Jacket, Flannel Shirt, Faux Fur Coat, Sequin Mini Skirt, Tie-Front Blouse, Cargo Shorts, Leopard Print Cardigan, Lace Camisole, Cropped Wide-Leg Pants, Velour Tracksuit, Embroidered Sweatshirt, Plaid Mini Skirt, Faux Suede Jacket, Ruffle Sleeve Top, Cotton Joggers, Tweed Blazer, Silk Slip Skirt, Denim Overall Dress, Lace Trim Blouse, Cropped Cargo Pants, Faux Shearling Coat, Striped Maxi Dress, Camo Print Jacket, Tassel Earrings, Embroidered Kimono, Floral Print Romper, Cropped Denim Jacket, Tie-Dye T-shirt, Pleated Chiffon Skirt, Faux Leather Moto Jacket, Sequin Bomber Jacket, Cotton Pajama Set, Linen Button-Up Shirt, Tropical Print Maxi Dress, Ruffled Wrap Dress, Plaid Scarf, Fringe Hem Jeans, Velvet Wrap Top, Embroidered Maxi Dress, Corduroy Skirt, Leopard Print Blouse, Lace-Up Boots, Faux Fur Vest, Sequin Pencil Skirt, Tie-Front Crop Top, Cargo Joggers, Floral Print Kimono, Ruffled Sleeve Blouse, Distressed Boyfriend Jeans, Paisley Print Dress, Knit Cardigan, Embroidered Denim Shorts, Flannel Pajama Set, Faux Leather Leggings, Sequin Mini Dress, Tropical Print Shorts, Ruffled Wrap Skirt, Plaid Mini Dress, Fringe Hem Skirt, Velvet Wrap Dress, Embroidered Maxi Skirt, Corduroy Jacket, Leopard Print Pants, Lace-Up Sneakers, Faux Fur Jacket, Sequin Crop Top, Tie-Dye Maxi Dress, Cargo Skirt, Floral Print Jumpsuit, Ruffled Sleeve Dress, Distressed Skinny Jeans, Paisley Print Blouse, Knit Scarf, Embroidered Denim Jacket, Flannel Button-Up Shirt, Faux Leather Skirt, Sequin Midi Skirt, Tropical Print Top, Ruffled Wrap Top, Plaid Midi Skirt, Fringe Hem Shorts, Velvet Wrap Skirt, Embroidered Mini Dress, Corduroy Pants, Leopard Print Skirt, Lace-Up Heels, Faux Fur Scarf, Sequin Wide-Leg Pants, Tie-Dye Romper";
		ArrayList<String> brands = new ArrayList<>(Arrays.asList(brandStrings.split(", ")));
		ArrayList<String> names = new ArrayList<>(Arrays.asList(productStrings.split(", ")));

		LocalDateTime min = LocalDateTime.of(2023, 1, 1, 0, 0, 0);
		LocalDateTime max = LocalDateTime.of(2023, 12, 30, 0, 0, 0);

		RandomRecordResultGenerator randomRecordResultGenerator = new RandomRecordResultGenerator();
		//when
		RecordResult recordResult = randomRecordResultGenerator.generator(5000000, list,
			new IncreaseNumbersSet(0, 1), new LocalDateRandomSet(min, max), new LocalDateRandomSet(min, max),
			new TextRandomSet(brands), new EnumRandomSet<>(Category.class), new TextRandomSet(names),
			() -> {
				long price = ThreadLocalRandom.current().nextLong(1000, 1000000);
				return String.valueOf(price - price % 10);
			}
		);
		//then

	}

}