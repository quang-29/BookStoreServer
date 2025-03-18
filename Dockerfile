import React from "react";import { View, Text, Image, StyleSheet, ScrollView, TouchableOpacity } from "react-native";import { Ionicons } from "@expo/vector-icons";import { COLORS, SIZES } from "../../constants/theme";import FormatMoney from "../../components/FormatMoney";import { useRouter, useSearchParams } from "expo-router";const BookDetails = () => {  const router = useRouter();  const { bookId, bookTitle, bookImage, bookDescription, bookPrice } = useSearchParams();  // Function to navigate back  const handleGoBack = () => {    router.back();  };  return (    <ScrollView style={styles.container}>      <Image source={{ uri: bookImage }} style={styles.bookImage} />      <View style={styles.detailsContainer}>        {/* Back Button */}        <TouchableOpacity onPress={handleGoBack} style={styles.backButton}>          <Ionicons name="arrow-back" size={24} color={COLORS.primary} />          <Text style={styles.backButtonText}>Back</Text>        </TouchableOpacity>        {/* Book Title */}        <Text style={styles.bookTitle}>{bookTitle}</Text>        {/* Book Price */}        <Text style={styles.bookPrice}>{FormatMoney(bookPrice)}</Text>        {/* Book Description */}        <Text style={styles.bookDescription}>          {bookDescription || "No description available."}        </Text>        {/* Action Icons (Add to Cart, Wishlist) */}        <View style={styles.iconContainer}>          <TouchableOpacity>            <Ionicons name="heart-outline" size={24} color={COLORS.dark} />          </TouchableOpacity>          <TouchableOpacity>            <Ionicons name="cart-outline" size={24} color={COLORS.dark} />          </TouchableOpacity>        </View>      </View>    </ScrollView>  );};const styles = StyleSheet.create({  container: {    flex: 1,    backgroundColor: COLORS.lightGray,  },  bookImage: {    width: "100%",    height: 300,    borderBottomLeftRadius: 20,    borderBottomRightRadius: 20,  },  detailsContainer: {    padding: 20,  },  backButton: {    flexDirection: "row",    alignItems: "center",    marginBottom: 15,  },  backButtonText: {    fontSize: 18,    color: COLORS.primary,    marginLeft: 10,  },  bookTitle: {    fontSize: 24,    fontWeight: "bold",    color: COLORS.dark,    marginBottom: 10,  },  bookPrice: {    fontSize: 20,    color: COLORS.red,    marginBottom: 10,  },  bookDescription: {    fontSize: 16,    color: COLORS.dark,    marginBottom: 20,  },  iconContainer: {    flexDirection: 'row',    justifyContent: 'space-between',    width: '100%',    marginTop: 10,  },});export default BookDetails;