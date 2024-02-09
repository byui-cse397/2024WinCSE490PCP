
# Database White Paper
### Authors: Brian Anderson, Kjellden Knutzen, Nazanal Laughlin, Jessica Vargas, Bryan Welton 

# Introduction

In the fast-evolving landscape of data analysis, the choice of tools plays a
crucial role in determining the efficiency and speed of processing. British
Mathematician Clive Humby aptly likened data to the new oil (Suarez-Davis,
2022), emphasizing its immense value. This white paper explores various data
processing technologies and compares their strengths and weaknesses.

# Programming Languages for Data Analysis

## Language Comparison

Python stands out as a powerhouse for data processing, emerging as one of the
most popular programming languages in this domain. Its versatility and extensive
community support make it a go-to choice for many professionals. Python enables
extended programming functionality that surpasses SQL in terms of functionality,
at the cost of efficiency.

## Reevaluating Pandas

Despite its popularity, Pandas, a Python library, has limitations. Designed in
2008, it struggles to keep up with modern data demands. Pandas, executing code
on a single core with long write times, faces challenges in optimizing speed for
contemporary computing (Sajid 2024).

# Accelerating Data Processing with Apache Arrow

## Introduction to Apache Arrow

Apache Arrow marks a significant leap in data analytics, addressing speed issues
prevalent in many modern data processing formats. It introduces a standardized
storage format, known as record batches, optimizing data retrieval from memory.

## Polars: Unleashing Speed with Apache Arrow

Polars, a Python library built on Apache Arrow's design, surpasses Pandas in
terms of speed. Offering processing speeds hundreds of times faster (Polars,
2024), Polars becomes a formidable choice for both full-time Data Scientists and
occasional data handlers.

![Polars vs Pandas Runtime Speeds](https://pola.rs/_astro/perf-illustration.842c8328_2dRYyE.svg)

# Enhancing Efficiency with Apache Parquet

## Understanding Apache Parquet

Efficiency gains come from making data more accessible to computers. While CSV
files are uncompressed and human-readable, Apache Parquet files offer
compression and formatting, making them ideal for Arrow optimizations and other
advanced techniques.

## Real-life Impact: AWS Server Costs

A comparative chart showcases the tangible benefits of processing data in the
Parquet format on AWS servers. The speed and space efficiency achieved through
this format are remarkable.

![Parquet vs CSV Speeds on AWS](https://cdn-images-1.medium.com/max/750/1*Tmw-dLB3m74Uv-cCCTph2Q.png)

# Scaling Data Processing with Apache Spark

## Beyond Terabytes: The Need for Scalability

As data volumes skyrocket, the limitations of a single machine become apparent.
Apache Spark, built on Apache Hadoop for easy distributed computing, addresses
this challenge by providing a scalable solution for processing vast datasets.

## Spark's Elegance: Lazy Operations and Optimization Engine

Spark's frontend support in popular languages, lazy operations, and an efficient
optimization engine make it an invaluable tool for teams across various
professions. Its seamless integration and connectivity with many powerful
technologies enhances its appeal.

# Our Recommendation

## Working With Apache Spark

Apache Spark scales easily thanks to its distributed computing capacity and
offers native implementations that help to ease the cost for computationally
expensive processes like machine learning. Spark runs a Java Backend that is
much more efficient than python, elevating quick scripting to the powerful
functionality that can often only be achieved in low-level, optimized,
time-intensive programming languages. Spark has the same speed advantages of
Apache Arrow thanks to its in memory format for processing data. Working with
powerful formats for data storage like Apache Parquet is a seamless operation in
Spark. The clear recommendation for its efficiency in speed, the size of data
that can be handled, and technologies that it integrates is Apache Spark.

# Citations:

Suarez-Davis, Jon. “Data Isn’t ‘the New Oil’ - It’s Way More Valuable than
That.” The Drum, The Drum, 12 Dec. 2022,
www.thedrum.com/opinion/2022/12/12/data-isn-t-the-new-oil-it-s-way-more-valuable.

Khan, Sajid. “An In-Depth Exploration of Pandas: Advantages, Disadvantages, and
Alternatives for Large-Scale Data...” Medium, Medium, 16 Nov. 2023,
medium.com/@sajidkhan.sjic/an-in-depth-exploration-of-pandas-advantages-disadvantages-and-alternatives-for-large-scale-data-cedf0b3d04aa.

“#demystifying Apache Arrow.” Your Sites RSS,
www.robinlinacre.com/demystifying_arrow/. Accessed 18 Jan. 2024.

“Polars.” Polars - Dataframes for the New Era, pola.rs/. Accessed 18 Jan. 2024.

Spicer, Thomas. “Apache Parquet vs. CSV Files - Dzone.” Dzone.Com, DZone, 28 May
2019, dzone.com/articles/how-to-be-a-hero-with-powerful-parquet-google-and.

“What Is Apache Spark.” Amazon, The University, 1978,
aws.amazon.com/what-is/apache-spark/.
